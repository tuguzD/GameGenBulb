package io.github.tuguzd.gamegenbulb.data

import android.util.Log
import android.util.Log.DEBUG
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import io.github.tuguzd.gamegenbulb.data.datasource.local.LocalGameDataSource
import io.github.tuguzd.gamegenbulb.data.datasource.remote.IgdbGameDataSource
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.util.dataOrNull

@OptIn(ExperimentalPagingApi::class)
class GameRemoteMediator(
    private val remoteDataSource: IgdbGameDataSource,
    private val localDataSource: LocalGameDataSource,
) : RemoteMediator<Int, Game>() {

    private var pageIndex = 0

    private fun getPageIndex(loadType: LoadType): Int? =
        when (loadType) {
            LoadType.REFRESH -> 0
            LoadType.PREPEND -> null
            LoadType.APPEND -> ++pageIndex
        }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Game>
    ): MediatorResult {
        pageIndex = getPageIndex(loadType)
            ?: return MediatorResult.Success(endOfPaginationReached = true)

        return try {
            val data = remoteDataSource.readAll(pageIndex).dataOrNull()!!
            Log.println(DEBUG, "GameList", data.toString())

            if (loadType != LoadType.REFRESH) {
                data.forEach { game ->
                    localDataSource.save(game)
                    Log.println(DEBUG, "Game", game.toString())
                }
            }
            MediatorResult.Success(
                endOfPaginationReached = false
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}
