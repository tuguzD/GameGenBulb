package io.github.tuguzd.gamegenbulb.data.model.remote

import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import kotlinx.serialization.Serializable

@Serializable
internal data class IgdbMode(
    val id: Long,
    val name: String?,
)

internal fun IgdbMode.toDomain() = Mode(
    id = Id(id.toString()),
    name = name,
)
