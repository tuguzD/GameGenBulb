package io.github.tuguzd.gamegenbulb.domain.model.content

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node

public data class Game(
    override val id: Id<Game>,
    val name: String,
    val desc: String,
    val modes: List<Mode>,
    val genres: List<String>,
) : Node
