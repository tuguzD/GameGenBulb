package io.github.tuguzd.gamegenbulb.domain.model

import java.util.UUID

@JvmInline
@Suppress("unused")
value class Id<Owner : Node>(private val value: UUID) {
    override fun toString(): String = value.toString()

    fun erase(): Id<*> = this

    fun <Other : Node> withOwner(): Id<Other> = Id(value)
}
