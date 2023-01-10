package io.github.tuguzd.gamegenbulb.data.repository

import io.github.tuguzd.gamegenbulb.data.datasource.local.LocalModeDataSource
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.repository.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

class ModeRepositoryImpl(
//    private val remoteDataSource: IgdbModeDataSource,
    private val localDataSource: LocalModeDataSource,
) : ModeRepository {

    override suspend fun save(item: Mode):
        DomainResult<Mode> = localDataSource.save(item)

    override suspend fun read(id: Id<Mode>):
        DomainResult<Mode?> = localDataSource.read(id)

    override suspend fun search(input: String):
        DomainResult<List<Mode>> = localDataSource.search(input)

    override suspend fun readAllOf(page: Int, item: Id<Game>):
        DomainResult<List<Mode>> = localDataSource.readAll(page, game = item)
}
