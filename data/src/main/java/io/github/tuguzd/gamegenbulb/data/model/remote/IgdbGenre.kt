package io.github.tuguzd.gamegenbulb.data.model.remote

import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import kotlinx.serialization.Serializable

@Serializable
internal data class IgdbGenre(
    val id: Long = 0,
    val name: String? = null,
)

internal fun IgdbGenre.toDomain() = Genre(
    id = Id(id.toString()),
    name = name,
)
