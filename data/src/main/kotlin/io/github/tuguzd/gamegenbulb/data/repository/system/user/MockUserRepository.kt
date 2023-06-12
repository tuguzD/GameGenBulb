package io.github.tuguzd.gamegenbulb.data.repository.system.user

import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UpdateUserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserCredentials
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserId
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.role.Role
import io.github.tuguzd.gamegenbulb.domain.model.util.exception.BaseException
import io.github.tuguzd.gamegenbulb.domain.model.util.result.error
import io.github.tuguzd.gamegenbulb.domain.model.util.result.success
import io.github.tuguzd.gamegenbulb.domain.repository.RepositoryResult
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import java.util.UUID
import kotlin.time.Duration.Companion.seconds

class MockUserRepository : UserRepository {
    override suspend fun signIn(credentials: UserCredentials): RepositoryResult<User> {
        delay(2.seconds)

        val name = credentials.name
        val user = users.asSequence().find { (_, data) -> data.name == name }
        if (user == null) {
            val cause = IllegalStateException("""No user found with name "$name"""")
            return error(BaseException.Unknown(cause))
        }

        val (id, data) = user
        return success(User(id, data))
    }

    override suspend fun signUp(credentials: UserCredentials): RepositoryResult<User> {
        delay(2.seconds)

        val name = credentials.name
        val data = users.values.find { data -> data.name == name }
        if (data != null) {
            val cause = IllegalStateException("""User with name "$name" already exists""")
            return error(BaseException.Unknown(cause))
        }

        val id = UserId(UUID.randomUUID())
        val new = UserData(
            name = name,
            displayName = name,
            role = Role.User,
            email = null,
            phone = null,
            avatar = null,
        )
        users[id] = new
        usersStateFlow.emit(users)
        return success(User(id, new))
    }

    override suspend fun signOut(id: UserId): RepositoryResult<User> {
        delay(2.seconds)

        val data = users[id]
        if (data == null) {
            val cause = IllegalStateException("""No user found with identifier "$id"""")
            return error(BaseException.Unknown(cause))
        }
        return success(User(id, data))
    }

    override suspend fun read(filters: UserFilters): RepositoryResult<Flow<List<User>>> {
        val users = usersStateFlow.map { users ->
            users.map { (id, data) -> User(id, data) }
                .filter { user -> filters satisfies user }
        }
        return success(users)
    }

    override suspend fun update(id: UserId, update: UpdateUserData): RepositoryResult<User> {
        delay(2.seconds)

        val data = users[id]
        if (data == null) {
            val cause = IllegalStateException("""No user found with identifier "$id"""")
            return error(BaseException.Unknown(cause))
        }

        val updated = data.copy(
            name = update.name ?: data.name,
            displayName = update.displayName ?: data.displayName,
            email = update.email ?: data.email,
            avatar = update.avatar ?: data.avatar,
        )
        users[id] = updated
        usersStateFlow.emit(users)
        return success(User(id, updated))
    }

    override suspend fun delete(id: UserId): RepositoryResult<User> {
        delay(2.seconds)

        val data = users.remove(id)
        if (data == null) {
            val cause = IllegalStateException("""No user found with identifier "$id"""")
            return error(BaseException.Unknown(cause))
        }
        usersStateFlow.emit(users)
        return success(User(id, data))
    }

    private val users = mutableMapOf(
        UserId(UUID.randomUUID()) to UserData(
            name = "tuguzD",
            displayName = "Damir Tugushev",
            role = Role.Administrator,
            email = "0damir.1tugushev@gmail.com",
            phone = "+7 (977) 794-18-85",
            avatar = "https://avatars.githubusercontent.com/u/56772528",
        ),
    )
    private val usersStateFlow = MutableStateFlow(users)
}
