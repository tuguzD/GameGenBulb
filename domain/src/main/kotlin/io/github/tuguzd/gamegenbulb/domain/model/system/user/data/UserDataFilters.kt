package io.github.tuguzd.gamegenbulb.domain.model.system.user.data

import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.avatar.AvatarFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.display.DisplayNameFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.email.EmailFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name.NameFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.role.RoleFilters
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.satisfies

data class UserDataFilters(
    val name: NameFilters? = null,
    val displayName: DisplayNameFilters? = null,
    val role: RoleFilters? = null,
    val email: EmailFilters? = null,
    val avatar: AvatarFilters? = null,
) : Filter<UserData> {
    override fun satisfies(input: UserData): Boolean =
        name satisfies input.name &&
                displayName satisfies input.displayName &&
                role satisfies input.role &&
                email satisfies input.email &&
                avatar satisfies input.avatar
}
