package io.github.tuguzd.gamegenbulb.domain.repository.util.business

import io.github.tuguzd.gamegenbulb.domain.model.util.Node

public interface SearchRepository<T : Node> {
    public suspend fun search(input: String): List<T>
}
