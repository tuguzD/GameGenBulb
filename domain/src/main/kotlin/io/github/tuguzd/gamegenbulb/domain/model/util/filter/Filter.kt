package io.github.tuguzd.gamegenbulb.domain.model.util.filter

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.root.And
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.root.Not

fun interface Filter<in Input> {
    infix fun satisfies(input: Input): Boolean
}

infix fun <Input> Filter<Input>?.satisfies(input: Input): Boolean =
    when (val filter = this) {
        null -> true
        else -> filter satisfies input
    }

operator fun <Input> Filter<Input>.not(): Not<Input> = Not(this)

operator fun <Input> Filter<Input>.plus(
    other: Filter<Input>
): And<Input> = And(this, other)
