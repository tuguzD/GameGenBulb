package io.github.tuguzd.gamegenbulb.data.datasource.interfaces

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

interface GenreDataSource {
    suspend fun read(id: Id<Genre>):
        DomainResult<Genre?>

    suspend fun readAll(page: Int, game: Id<Game>):
        DomainResult<List<Genre>>

    suspend fun save(item: Genre):
        DomainResult<Genre>

    suspend fun search(input: String):
        DomainResult<List<Genre>>
}
