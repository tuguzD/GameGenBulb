package io.github.tuguzd.gamegenbulb.data.datasource.remote

import io.github.tuguzd.gamegenbulb.data.datasource.remote.util.toResult
import io.github.tuguzd.gamegenbulb.data.model.remote.IgdbGame
import io.github.tuguzd.gamegenbulb.data.model.remote.IgdbGenre
import io.github.tuguzd.gamegenbulb.data.model.remote.IgdbMode
import io.github.tuguzd.gamegenbulb.data.model.remote.toDomain
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.*

class IgdbGameDataSource(apiClient: IgdbApiClient) {
    private val gameApi = apiClient.gameApi

    suspend fun read(id: Id<Game>): DomainResult<Game?> =
        gameApi.read(id.id).toResult().map(IgdbGame::toDomain)

    suspend fun search(input: String): DomainResult<List<Game>> =
        when (val result = gameApi.search(input).toResult()) {
            is Result.Error -> result.cast()
            is Result.Success -> success(
                result.data.map(IgdbGame::toDomain)
            )
        }

    suspend fun readAll(page: Int = 0, limit: Int = 10): DomainResult<List<Game>> =
        when (val result = gameApi.readAll(page, limit).toResult()) {
            is Result.Error -> result.cast()
            is Result.Success -> success(
                result.data.map(IgdbGame::toDomain)
            )
        }
}

internal fun IgdbGame.toDomain() = Game(
    id = Id(id.toString()),
    name = name, desc = desc,
    modes = modes.map(IgdbMode::toDomain),
    genres = genres.map(IgdbGenre::toDomain),
)
