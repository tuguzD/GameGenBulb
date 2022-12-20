package io.github.tuguzd.gamegenbulb.domain.usecase.util.business

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.SearchRepository

public open class SearchUseCase<T : Node>(
    private val domainRepository: SearchRepository<T>
) : suspend (String) -> List<T> {
    public override suspend
    fun invoke(input: String): List<T> =
        domainRepository.search(input)
}
