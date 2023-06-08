package io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter

data class Contains<T>(val value: T) : Filter<Iterable<T>> {
    override fun satisfies(input: Iterable<T>): Boolean = value in input
}
