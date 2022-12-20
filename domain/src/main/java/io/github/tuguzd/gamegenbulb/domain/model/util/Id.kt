package io.github.tuguzd.gamegenbulb.domain.model.util

@JvmInline
public value class Id<
    @Suppress("unused")
    Owner : Node>(public val id: String)

public fun <Owner : Node, Other : Node> Id<Owner>.changeOwner(): Id<Other> = Id(this.id)
