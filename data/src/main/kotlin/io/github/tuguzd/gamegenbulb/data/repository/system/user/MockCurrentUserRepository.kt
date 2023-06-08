package io.github.tuguzd.gamegenbulb.data.repository.system.user

import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.util.result.success
import io.github.tuguzd.gamegenbulb.domain.repository.RepositoryResult
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.CurrentUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MockCurrentUserRepository : CurrentUserRepository {
    override fun read(): Flow<User?> = currentUserFlow.asStateFlow()

    override suspend fun set(user: User?): RepositoryResult<User?> {
        currentUserFlow.value = user
        return success(user)
    }

    private val currentUserFlow: MutableStateFlow<User?> = MutableStateFlow(null)
}
