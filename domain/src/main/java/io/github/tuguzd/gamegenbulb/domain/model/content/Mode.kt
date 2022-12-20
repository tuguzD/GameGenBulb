package io.github.tuguzd.gamegenbulb.domain.model.content

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node

public data class Mode(
    override val id: Id<Mode>,
    val name: String
) : Node
