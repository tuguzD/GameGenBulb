package io.github.tuguzd.gamegenbulb.domain.usecase.util.business

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.SearchRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public open class SearchUseCase<T : Node>(
    private val domainRepository: SearchRepository<T>
) : suspend (String) -> DomainResult<List<T>> {
    public override suspend
    fun invoke(input: String): DomainResult<List<T>> =
        domainRepository.search(input)
}
