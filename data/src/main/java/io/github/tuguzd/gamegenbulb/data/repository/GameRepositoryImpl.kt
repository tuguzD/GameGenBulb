package io.github.tuguzd.gamegenbulb.data.repository

import io.github.tuguzd.gamegenbulb.data.datasource.local.LocalGameDataSource
import io.github.tuguzd.gamegenbulb.data.datasource.remote.IgdbGameDataSource
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.repository.GameRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

class GameRepositoryImpl(
    private val remoteDataSource: IgdbGameDataSource,
    private val localDataSource: LocalGameDataSource,
) : GameRepository {

    override suspend fun save(item: Game):
        DomainResult<Game> = localDataSource.save(item)

    override suspend fun read(id: Id<Game>):
        DomainResult<Game?> = remoteDataSource.read(id)

    override suspend fun search(input: String):
        DomainResult<List<Game>> = remoteDataSource.search(input)

    override suspend fun readAll(page: Int):
        DomainResult<List<Game>> = remoteDataSource.readAll(page)
}
