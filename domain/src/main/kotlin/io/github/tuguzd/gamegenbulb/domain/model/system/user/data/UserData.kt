package io.github.tuguzd.gamegenbulb.domain.model.system.user.data

import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.avatar.Avatar
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.display.DisplayName
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.email.Email
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name.Name
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.phone.Phone
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.role.Role

data class UserData(
    val name: Name,
    val displayName: DisplayName,
    val role: Role,
    val email: Email?,
    val phone: Phone?,
    val avatar: Avatar?,
)
