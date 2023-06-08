package io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.Equal
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.NotEqual
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.In
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.NotIn
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.root.Regex
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.satisfies

data class NameFilters(
    val eq: Equal<Name>? = null,
    val ne: NotEqual<Name>? = null,
    val `in`: In<Name>? = null,
    val nin: NotIn<Name>? = null,
    val regex: Regex? = null,
) : Filter<Name> {
    override fun satisfies(input: Name): Boolean =
        eq satisfies input &&
                ne satisfies input &&
                `in` satisfies input &&
                nin satisfies input &&
                regex satisfies input
}
