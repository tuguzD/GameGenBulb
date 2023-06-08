package io.github.tuguzd.gamegenbulb.domain.model.system.user.util.avatar

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.Equal
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.NotEqual
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.In
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.NotIn
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.root.Regex
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.satisfies

data class AvatarFilters(
    val eq: Equal<Avatar?>? = null,
    val ne: NotEqual<Avatar?>? = null,
    val `in`: In<Avatar?>? = null,
    val nin: NotIn<Avatar?>? = null,
    val regex: Regex?,
) : Filter<Avatar?> {
    override fun satisfies(input: Avatar?): Boolean =
        eq satisfies input &&
                ne satisfies input &&
                `in` satisfies input &&
                nin satisfies input &&
                input?.let { regex satisfies input } ?: true
}
