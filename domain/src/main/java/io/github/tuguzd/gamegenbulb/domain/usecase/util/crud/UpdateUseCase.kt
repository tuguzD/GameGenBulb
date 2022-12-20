package io.github.tuguzd.gamegenbulb.domain.usecase.util.crud

import io.github.tuguzd.gamegenbulb.domain.model.util.Id
import io.github.tuguzd.gamegenbulb.domain.model.util.Node
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.UpdateRepository

public open class UpdateUseCase<T : Node>(
    private val domainRepository: UpdateRepository<T>
) : suspend (Id<T>) -> T {
    public override suspend
    fun invoke(id: Id<T>): T =
        domainRepository.update(id)
}
