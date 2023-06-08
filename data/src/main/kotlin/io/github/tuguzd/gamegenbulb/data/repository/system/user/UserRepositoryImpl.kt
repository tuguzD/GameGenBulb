package io.github.tuguzd.gamegenbulb.data.repository.system.user

import io.github.tuguzd.gamegenbulb.data.datasource.system.user.LocalUserDataSource
import io.github.tuguzd.gamegenbulb.data.datasource.system.user.RemoteUserDataSource
import io.github.tuguzd.gamegenbulb.data.datasource.util.LocalClient
import io.github.tuguzd.gamegenbulb.data.datasource.util.RemoteClient
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UpdateUserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserCredentials
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserId
import io.github.tuguzd.gamegenbulb.domain.repository.RepositoryResult
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(local: LocalClient, remote: RemoteClient) : UserRepository {
    private val local = LocalUserDataSource(local)
    private val remote = RemoteUserDataSource(remote)

    override suspend fun signIn(credentials: UserCredentials): RepositoryResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(credentials: UserCredentials): RepositoryResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun signOut(id: UserId): RepositoryResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun read(filters: UserFilters): RepositoryResult<Flow<List<User>>> {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: UserId, update: UpdateUserData): RepositoryResult<User> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: UserId): RepositoryResult<User> {
        TODO("Not yet implemented")
    }
}
