package io.github.tuguzd.gamegenbulb.domain.repository.util.business

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public interface SearchRepository<T : Node> {
    public suspend fun search(input: String): DomainResult<List<T>>
}
