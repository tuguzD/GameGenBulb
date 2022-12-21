package io.github.tuguzd.gamegenbulb.domain.usecase.util.crud

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.UpdateRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public open class UpdateUseCase<T : Node>(
    private val domainRepository: UpdateRepository<T>
) : suspend (Id<T>) -> DomainResult<T> {
    public override suspend
    fun invoke(id: Id<T>): DomainResult<T> =
        domainRepository.update(id)
}
