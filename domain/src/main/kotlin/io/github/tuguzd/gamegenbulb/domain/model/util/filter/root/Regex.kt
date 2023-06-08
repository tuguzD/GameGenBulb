package io.github.tuguzd.gamegenbulb.domain.model.util.filter.root

import io.github.tuguzd.gamegenbulb.domain.model.util.filter.Filter
import kotlin.text.Regex

data class Regex(val regex: Regex) : Filter<CharSequence> {
    override fun satisfies(input: CharSequence): Boolean = regex matches input
}
