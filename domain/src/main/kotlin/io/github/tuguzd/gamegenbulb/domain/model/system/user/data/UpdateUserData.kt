package io.github.tuguzd.gamegenbulb.domain.model.system.user.data

import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.avatar.Avatar
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.display.DisplayName
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.email.Email
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name.Name
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.role.Role

data class UpdateUserData(
    val name: Name? = null,
    val displayName: DisplayName? = null,
    val role: Role? = null,
    val email: Email? = null,
    val avatar: Avatar? = null,
)
