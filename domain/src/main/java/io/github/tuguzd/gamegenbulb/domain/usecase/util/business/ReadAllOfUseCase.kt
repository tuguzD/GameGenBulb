package io.github.tuguzd.gamegenbulb.domain.usecase.util.business

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.ReadAllOfRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public open class ReadAllOfUseCase<T : Node, L : Node>(
    private val domainRepository: ReadAllOfRepository<T, L>
) : suspend (Int, Id<T>) -> DomainResult<List<L>> {
    public override suspend
    fun invoke(page: Int, item: Id<T>): DomainResult<List<L>> =
        domainRepository.readAllOf(page, item)
}
