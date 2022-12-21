package io.github.tuguzd.gamegenbulb.domain.usecase.util.business

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.ReadAllRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public open class ReadAllUseCase<T : Node>(
    private val domainRepository: ReadAllRepository<T>
) : suspend () -> DomainResult<List<T>> {
    public override suspend
    fun invoke(): DomainResult<List<T>> =
        domainRepository.readAll()
}
