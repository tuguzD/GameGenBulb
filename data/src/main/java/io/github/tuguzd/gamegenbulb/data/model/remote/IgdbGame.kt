package io.github.tuguzd.gamegenbulb.data.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class IgdbGame(
    val id: Long = 0,
    val name: String? = null,
    @SerialName("summary") val desc: String? = null,
    @SerialName("game_modes") val modes: List<IgdbMode> = listOf(),
    val genres: List<IgdbGenre> = listOf(),
)
