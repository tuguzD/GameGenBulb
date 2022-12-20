package io.github.tuguzd.gamegenbulb.domain.repository.util.crud

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node

public interface UpdateRepository<T : Node> {
    public suspend fun update(id: Id<T>): T
}
