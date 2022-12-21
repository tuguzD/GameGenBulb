package io.github.tuguzd.gamegenbulb.domain.repository.util.business

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public interface ReadAllRepository<T : Node> {
    public suspend fun readAll(input: String): DomainResult<List<T>>
}
