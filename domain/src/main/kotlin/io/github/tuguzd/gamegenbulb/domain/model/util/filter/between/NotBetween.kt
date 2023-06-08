package io.github.tuguzd.gamegenbulb.domain.model.util.filter.between

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter

data class NotBetween<T>(
    val min: T,
    val max: T,
) : Filter<T> where T : Comparable<T> {
    override fun satisfies(input: T): Boolean = input < min || max < input
}
