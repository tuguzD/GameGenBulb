package io.github.tuguzd.gamegenbulb.domain.model.system.user.util.display

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.Equal
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.NotEqual
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.In
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.NotIn
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.root.Regex
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.satisfies

data class DisplayNameFilters(
    val eq: Equal<DisplayName>? = null,
    val ne: NotEqual<DisplayName>? = null,
    val `in`: In<DisplayName>? = null,
    val nin: NotIn<DisplayName>? = null,
    val regex: Regex? = null,
) : Filter<DisplayName> {
    override fun satisfies(input: DisplayName): Boolean =
        eq satisfies input &&
                ne satisfies input &&
                `in` satisfies input &&
                nin satisfies input &&
                regex satisfies input
}
