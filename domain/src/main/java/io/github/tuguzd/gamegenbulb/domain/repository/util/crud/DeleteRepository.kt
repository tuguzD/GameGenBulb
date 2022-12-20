package io.github.tuguzd.gamegenbulb.domain.repository.util.crud

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node

public interface DeleteRepository<T : Node> {
    public suspend fun delete(id: Id<T>): T
}
