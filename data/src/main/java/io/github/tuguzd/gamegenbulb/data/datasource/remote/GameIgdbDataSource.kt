package io.github.tuguzd.gamegenbulb.data.datasource.remote

import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.GameDataSource
import io.github.tuguzd.gamegenbulb.data.datasource.remote.util.toResult
import io.github.tuguzd.gamegenbulb.data.model.remote.IgdbGame
import io.github.tuguzd.gamegenbulb.data.model.remote.toDomain
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.*

class GameIgdbDataSource(apiClient: IgdbApiClient) : GameDataSource {
    private val gameApi = apiClient.gameApi

    override suspend fun read(id: Id<Game>): DomainResult<Game?> =
        gameApi.read(id.id).toResult().map(IgdbGame::toDomain)

    override suspend fun search(input: String): DomainResult<List<Game>> =
        when (val result = gameApi.search(input).toResult()) {
            is Result.Error -> result.cast()
            is Result.Success -> success(
                result.data.map(IgdbGame::toDomain)
            )
        }

    override suspend fun readAll(): DomainResult<List<Game>> =
        when (val result = gameApi.readAll().toResult()) {
            is Result.Error -> result.cast()
            is Result.Success -> success(
                result.data.map(IgdbGame::toDomain)
            )
        }

    override suspend fun create(item: Game): DomainResult<Game> {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: Id<Game>): DomainResult<Game> {
        TODO("Not yet implemented")
    }
}
