package io.github.tuguzd.gamegenbulb.data.repository

import io.github.tuguzd.gamegenbulb.data.datasource.local.LocalGenreDataSource
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.repository.GenreRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

class GenreRepositoryImpl(
//    private val remoteDataSource: IgdbGenreDataSource,
    private val localDataSource: LocalGenreDataSource,
) : GenreRepository {

    override suspend fun save(item: Genre):
        DomainResult<Genre> = localDataSource.save(item)

    override suspend fun read(id: Id<Genre>):
        DomainResult<Genre?> = localDataSource.read(id)

    override suspend fun search(input: String):
        DomainResult<List<Genre>> = localDataSource.search(input)

    override suspend fun readAllOf(page: Int, item: Id<Game>):
        DomainResult<List<Genre>> = localDataSource.readAll(page, game = item)
}
