package io.github.tuguzd.gamegenbulb.data.repository

import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.ModeDataSource
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.repository.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

class ModeRepositoryImpl(
    private val dataSource: ModeDataSource
) : ModeRepository {

    override suspend fun save(item: Mode):
        DomainResult<Mode> = dataSource.save(item)

    override suspend fun read(id: Id<Mode>):
        DomainResult<Mode?> = dataSource.read(id)

    override suspend fun search(input: String):
        DomainResult<List<Mode>> = dataSource.search(input)

    override suspend fun readAllOf(page: Int, item: Id<Game>):
        DomainResult<List<Mode>> = dataSource.readAll(page, item)
}
