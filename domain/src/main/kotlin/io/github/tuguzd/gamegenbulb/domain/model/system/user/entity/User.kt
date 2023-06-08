package io.github.tuguzd.gamegenbulb.domain.model.system.user.entity

import io.github.tuguzd.gamegenbulb.domain.model.Node
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserData

data class User(
    override val id: UserId,
    val data: UserData,
) : Node
