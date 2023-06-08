package io.github.tuguzd.gamegenbulb.domain.repository.system.user

import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UpdateUserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserCredentials
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserId
import io.github.tuguzd.gamegenbulb.domain.repository.RepositoryResult
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun signIn(credentials: UserCredentials): RepositoryResult<User>

    suspend fun signUp(credentials: UserCredentials): RepositoryResult<User>

    suspend fun signOut(id: UserId): RepositoryResult<User>

    suspend fun read(filters: UserFilters): RepositoryResult<Flow<List<User>>>

    suspend fun update(id: UserId, update: UpdateUserData): RepositoryResult<User>

    suspend fun delete(id: UserId): RepositoryResult<User>
}
