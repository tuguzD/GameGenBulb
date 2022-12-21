package io.github.tuguzd.gamegenbulb.data.datasource.interfaces

import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

interface ModeDataSource {
    suspend fun create(item: Mode):
        DomainResult<Mode>

    suspend fun read(id: Id<Mode>):
        DomainResult<Mode?>

    suspend fun readAll():
        DomainResult<List<Mode>>

    suspend fun update(id: Id<Mode>):
        DomainResult<Mode>

    suspend fun search(input: String):
        DomainResult<List<Mode>>
}
