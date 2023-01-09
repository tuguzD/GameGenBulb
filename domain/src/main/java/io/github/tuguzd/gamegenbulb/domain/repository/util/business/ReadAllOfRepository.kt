package io.github.tuguzd.gamegenbulb.domain.repository.util.business

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public interface ReadAllOfRepository<T : Node, L : Node> {
    public suspend fun readAllOf(page: Int, item: Id<T>): DomainResult<List<L>>
}
