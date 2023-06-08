package io.github.tuguzd.gamegenbulb.domain.model.util.filter.root

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter

data class Not<in Input>(val filter: Filter<Input>) : Filter<Input> {
    override fun satisfies(input: Input): Boolean = (filter satisfies input).not()
}
