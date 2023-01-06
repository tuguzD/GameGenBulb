package io.github.tuguzd.gamegenbulb.domain.model.util

@JvmInline
@Suppress("unused")
public value class Id<Owner : Node>(public val id: String) {
    override fun toString(): String = id
}

public fun <Owner : Node, Other : Node> Id<Owner>.changeOwner():
    Id<Other> = Id(this.id)
