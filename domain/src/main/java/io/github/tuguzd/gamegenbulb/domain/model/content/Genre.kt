package io.github.tuguzd.gamegenbulb.domain.model.content

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node

public data class Genre(
    override val id: Id<Genre>,
    val name: String?,
) : Node
