package io.github.tuguzd.gamegenbulb.data.datasource.system.user

import io.github.tuguzd.gamegenbulb.data.FilterUsersQuery
import io.github.tuguzd.gamegenbulb.data.datasource.util.RemoteClient
import io.github.tuguzd.gamegenbulb.data.type.UserRole
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserId
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.role.Role
import java.util.UUID

internal class RemoteUserDataSource(private val client: RemoteClient)

fun FilterUsersQuery.User.toDomain(): User = User(
    id = UserId(id as UUID),
    data = UserData(
        name = name,
        displayName = displayName,
        role = role.toDomain(),
        email = email,
        phone = phone,
        avatar = avatarUrl,
    ),
)

fun UserRole.toDomain(): Role = Role.valueOf(
    rawValue.lowercase().replaceFirstChar {
        if (it.isLowerCase()) it.titlecase() else it.toString()
    },
)
