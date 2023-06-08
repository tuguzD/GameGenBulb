package io.github.tuguzd.gamegenbulb.domain.model

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.Equal
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.NotEqual
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.In
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold.NotIn
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.satisfies

data class IdFilters<Owner : Node>(
    val eq: Equal<Id<Owner>>? = null,
    val ne: NotEqual<Id<Owner>>? = null,
    val `in`: In<Id<Owner>>? = null,
    val nin: NotIn<Id<Owner>>? = null,
) : Filter<Id<Owner>> {
    override fun satisfies(input: Id<Owner>): Boolean =
        eq satisfies input &&
                ne satisfies input &&
                `in` satisfies input &&
                nin satisfies input

    fun erase(): IdFilters<*> = this

    fun <Other : Node> withOwner(): IdFilters<Other> = IdFilters(
        eq = eq?.value?.let { id ->
            Equal(id.withOwner())
        },
        ne = ne?.value?.let { id ->
            NotEqual(id.withOwner())
        },
        `in` = `in`?.iterable?.let { ids ->
            In(ids.map { id -> id.withOwner() })
        },
        nin = nin?.iterable?.let { ids ->
            NotIn(ids.map { id -> id.withOwner() })
        },
    )
}
