package io.github.tuguzd.gamegenbulb.domain.model.util.filter.root

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter

data class And<in Input>(
    val first: Filter<Input>,
    val second: Filter<Input>,
) : Filter<Input> {
    override fun satisfies(input: Input): Boolean =
        (first satisfies input) && (second satisfies input)
}
