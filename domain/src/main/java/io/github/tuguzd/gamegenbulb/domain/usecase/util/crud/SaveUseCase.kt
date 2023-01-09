package io.github.tuguzd.gamegenbulb.domain.usecase.util.crud

import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.SaveRepository
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult

public open class SaveUseCase<T : Node>(
    private val domainRepository: SaveRepository<T>
) : suspend (T) -> DomainResult<T> {
    public override suspend
    fun invoke(item: T): DomainResult<T> =
        domainRepository.save(item)
}
