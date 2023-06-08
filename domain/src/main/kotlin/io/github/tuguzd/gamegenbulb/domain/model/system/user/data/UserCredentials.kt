package io.github.tuguzd.gamegenbulb.domain.model.system.user.data

import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name.Name

data class UserCredentials(
    val name: Name,
    val password: String,
)
