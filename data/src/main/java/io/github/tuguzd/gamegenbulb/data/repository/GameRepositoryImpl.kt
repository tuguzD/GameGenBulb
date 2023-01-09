package io.github.tuguzd.gamegenbulb.data.repository

import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.GameDataSource
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.repository.GameRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

class GameRepositoryImpl(
    private val dataSource: GameDataSource
) : GameRepository {

    override suspend fun create(item: Game):
        DomainResult<Game> = dataSource.create(item)

    override suspend fun read(id: Id<Game>):
        DomainResult<Game?> = dataSource.read(id)

    override suspend fun update(id: Id<Game>):
        DomainResult<Game> = dataSource.update(id)

    override suspend fun search(input: String):
        DomainResult<List<Game>> = dataSource.search(input)

    override suspend fun readAll(page: Int):
        DomainResult<List<Game>> = dataSource.readAll(page)
}
