package io.github.tuguzd.gamegenbulb.domain.repository.util.crud

import io.github.tuguzd.gamegenbulb.domain.model.util.Node

public interface CreateRepository<T : Node> {
    public suspend fun create(item: T): T
}
