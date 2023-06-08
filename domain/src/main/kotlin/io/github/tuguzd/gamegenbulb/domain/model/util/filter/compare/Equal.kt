package io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter

data class Equal<T>(val value: T) : Filter<T> {
    override fun satisfies(input: T): Boolean = value == input
}
