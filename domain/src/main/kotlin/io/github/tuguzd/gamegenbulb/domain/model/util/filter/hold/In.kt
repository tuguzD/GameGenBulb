package io.github.tuguzd.gamegenbulb.domain.model.util.filter.hold

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter

data class In<T>(val iterable: Iterable<T>) : Filter<T> {
    override fun satisfies(input: T): Boolean = input in iterable
}
