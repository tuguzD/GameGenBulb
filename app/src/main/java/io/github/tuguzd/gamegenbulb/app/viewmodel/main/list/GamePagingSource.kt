package io.github.tuguzd.gamegenbulb.app.viewmodel.main.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.usecase.content.game.ReadAllGameUseCase
import io.github.tuguzd.gamegenbulb.domain.util.Result

class GamePagingSource(
    private val readAllGameUseCase: ReadAllGameUseCase,
) : PagingSource<Int, Game>() {
    override fun getRefreshKey(state: PagingState<Int, Game>): Int? = state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        val page = params.key ?: 0
        val data = when (val result = readAllGameUseCase.invoke(page)) {
            is Result.Error -> throw result.error
            is Result.Success -> result.data
        }
        return LoadResult.Page(
            data = data, prevKey = if (page == 0) null else page - 1,
            nextKey = if (data.isEmpty()) null else page + 1,
        )
    }
}
