package io.github.tuguzd.gamegenbulb.data.datasource.interfaces

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

interface GameDataSource {
    suspend fun read(id: Id<Game>):
        DomainResult<Game?>

    suspend fun readAll(page: Int):
        DomainResult<List<Game>>

    suspend fun save(item: Game):
        DomainResult<Game>

    suspend fun search(input: String):
        DomainResult<List<Game>>
}
