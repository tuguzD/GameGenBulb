package io.github.tuguzd.gamegenbulb.domain.repository.util.crud

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public interface SaveRepository<T : Node> {
    public suspend fun save(item: T): DomainResult<T>
}
