package io.github.tuguzd.gamegenbulb.domain.repository.system.user

import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.repository.RepositoryResult
import kotlinx.coroutines.flow.Flow

interface CurrentUserRepository {
    fun read(): Flow<User?>

    suspend fun set(user: User?): RepositoryResult<User?>
}
