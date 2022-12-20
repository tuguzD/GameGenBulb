package io.github.tuguzd.gamegenbulb.domain.model.auth

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node

public data class User(
    override val id: Id<User>,
    /* val name: String,
    val email: String?, */
    val role: UserRole
) : Node
