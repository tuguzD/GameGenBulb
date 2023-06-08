package io.github.tuguzd.gamegenbulb.data.datasource.system.user

import io.github.tuguzd.gamegenbulb.data.datasource.util.LocalClient
import io.github.tuguzd.gamegenbulb.data.model.system.user.UserEntity
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserId
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.role.Role

internal class LocalUserDataSource(private val client: LocalClient)

fun UserEntity.toDomain(): User = User(
    id = UserId(requireNotNull(uuid)),
    data = UserData(
        name = requireNotNull(name),
        displayName = requireNotNull(displayName),
        role = Role.valueOf(requireNotNull(role)),
        email = email,
        avatar = avatar,
    ),
)
