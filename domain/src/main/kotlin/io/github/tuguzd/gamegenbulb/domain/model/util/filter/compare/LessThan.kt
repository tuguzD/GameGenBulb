package io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter

data class LessThan<T>(val value: T) : Filter<T> where T : Comparable<T> {
    override fun satisfies(input: T): Boolean = input < value
}
