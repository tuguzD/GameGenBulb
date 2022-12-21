package io.github.tuguzd.gamegenbulb.domain.usecase.util.crud

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.ReadRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public open class ReadUseCase<T : Node>(
    private val domainRepository: ReadRepository<T>
) : suspend (Id<T>) -> DomainResult<T?> {
    public override suspend
    fun invoke(id: Id<T>): DomainResult<T?> =
        domainRepository.read(id)
}
