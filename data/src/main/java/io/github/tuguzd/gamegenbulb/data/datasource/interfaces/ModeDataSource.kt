package io.github.tuguzd.gamegenbulb.data.datasource.interfaces

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

interface ModeDataSource {
    suspend fun read(id: Id<Mode>):
        DomainResult<Mode?>

    suspend fun readAll(page: Int, game: Id<Game>):
        DomainResult<List<Mode>>

    suspend fun save(item: Mode):
        DomainResult<Mode>

    suspend fun search(input: String):
        DomainResult<List<Mode>>
}
