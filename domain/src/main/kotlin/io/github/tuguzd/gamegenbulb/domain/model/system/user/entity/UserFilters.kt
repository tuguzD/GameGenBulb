package io.github.tuguzd.gamegenbulb.domain.model.system.user.entity

import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserDataFilters
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.satisfies

data class UserFilters(
    val id: UserIdFilters? = null,
    val data: UserDataFilters? = null,
) : Filter<User> {
    override fun satisfies(input: User): Boolean =
        id satisfies input.id && data satisfies input.data
}
