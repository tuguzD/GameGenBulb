package io.github.tuguzd.gamegenbulb.data.repository

import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.GenreDataSource
import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.repository.GenreRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

class GenreRepositoryImpl(
    private val dataSource: GenreDataSource
) : GenreRepository {

    override suspend fun create(item: Genre):
        DomainResult<Genre> = dataSource.create(item)

    override suspend fun read(id: Id<Genre>):
        DomainResult<Genre?> = dataSource.read(id)

    override suspend fun update(id: Id<Genre>):
        DomainResult<Genre> = dataSource.update(id)

    override suspend fun search(input: String):
        DomainResult<List<Genre>> = dataSource.search(input)

    override suspend fun readAll(input: String):
        DomainResult<List<Genre>> = dataSource.readAll()
}
