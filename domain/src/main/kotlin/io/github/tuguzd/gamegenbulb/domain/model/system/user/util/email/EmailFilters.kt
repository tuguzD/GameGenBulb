package io.github.tuguzd.gamegenbulb.domain.model.system.user.util.email

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.Equal
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.NotEqual
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.In
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.NotIn
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.root.Regex
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.satisfies

data class EmailFilters(
    val eq: Equal<Email?>? = null,
    val ne: NotEqual<Email?>? = null,
    val `in`: In<Email?>? = null,
    val nin: NotIn<Email?>? = null,
    val regex: Regex? = null,
) : Filter<Email?> {
    override fun satisfies(input: Email?): Boolean =
        eq satisfies input &&
                ne satisfies input &&
                `in` satisfies input &&
                nin satisfies input &&
                input?.let { regex satisfies input } ?: true
}
