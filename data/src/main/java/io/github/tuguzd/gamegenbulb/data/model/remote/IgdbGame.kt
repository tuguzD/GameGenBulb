package io.github.tuguzd.gamegenbulb.data.model.remote

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class IgdbGame(
    val id: Long,
    val name: String?,
    @SerialName("summary") val desc: String?,
    @SerialName("game_modes") val modes: List<IgdbMode>,
    val genres: List<IgdbGenre>,
)

internal fun IgdbGame.toDomain() = Game(
    id = Id(id.toString()),
    name = name, desc = desc,
    modes = modes.map(IgdbMode::toDomain),
    genres = genres.map(IgdbGenre::toDomain),
)
