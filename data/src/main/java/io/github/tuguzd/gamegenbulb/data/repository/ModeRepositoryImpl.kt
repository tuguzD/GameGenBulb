package io.github.tuguzd.gamegenbulb.data.repository

import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.ModeDataSource
import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.repository.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

class ModeRepositoryImpl(
    private val dataSource: ModeDataSource
) : ModeRepository {

    override suspend fun create(item: Mode):
        DomainResult<Mode> = dataSource.create(item)

    override suspend fun read(id: Id<Mode>):
        DomainResult<Mode?> = dataSource.read(id)

    override suspend fun update(id: Id<Mode>):
        DomainResult<Mode> = dataSource.update(id)

    override suspend fun search(input: String):
        DomainResult<List<Mode>> = dataSource.search(input)

    override suspend fun readAll(page: Int):
        DomainResult<List<Mode>> = dataSource.readAll(page)
}
