package io.github.tuguzd.gamegenbulb.domain.usecase.system.user.current

import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UpdateUserData
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserDataFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserIdFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.email.Email
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.email.EmailFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name.Name
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name.NameFilters
import io.github.tuguzd.gamegenbulb.domain.model.util.exception.BaseException
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.Equal
import io.github.tuguzd.gamegenbulb.domain.model.util.result.Result
import io.github.tuguzd.gamegenbulb.domain.model.util.result.error
import io.github.tuguzd.gamegenbulb.domain.model.util.result.success
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.CurrentUserRepository
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.UserRepository
import kotlinx.coroutines.flow.firstOrNull

class UpdateCurrentUser(
    private val userRepository: UserRepository,
    private val currentUserRepository: CurrentUserRepository,
) {
    suspend fun update(update: UpdateUserData): Result<User, Exception> {
        val currentUser = currentUserRepository.read().firstOrNull()
            ?: return error(Exception.NoCurrentUser)
        val id = currentUser.id

        val filters = UserFilters(id = UserIdFilters(eq = Equal(id)))
        val user = when (val result = userRepository.read(filters)) {
            is Result.Error -> return error(Exception.Repository(result.error))
            is Result.Success -> result.data.firstOrNull()?.firstOrNull()
        }
        user ?: return error(Exception.NoCurrentUser)

        @Suppress("NAME_SHADOWING")
        if (update.name != null) {
            val name = update.name
            val dataFilters = UserDataFilters(name = NameFilters(eq = Equal(name)))
            val filters = UserFilters(data = dataFilters)
            val user = when (val result = userRepository.read(filters)) {
                is Result.Error -> return error(Exception.Repository(result.error))
                is Result.Success -> result.data.firstOrNull()?.firstOrNull()
            }
            if (user != null) {
                return error(Exception.NameAlreadyTaken(name))
            }
        }

        @Suppress("NAME_SHADOWING")
        if (update.email != null) {
            val email = update.email
            val dataFilters = UserDataFilters(email = EmailFilters(eq = Equal(email)))
            val filters = UserFilters(data = dataFilters)
            val user = when (val result = userRepository.read(filters)) {
                is Result.Error -> return error(Exception.Repository(result.error))
                is Result.Success -> result.data.firstOrNull()
            }
            if (user != null) {
                return error(Exception.EmailAlreadyTaken(email))
            }
        }

        val updated = when (val result = userRepository.update(id, update)) {
            is Result.Error -> return error(Exception.Repository(result.error))
            is Result.Success -> result.data
        }
        return when (val result = currentUserRepository.set(updated)) {
            is Result.Error -> error(Exception.Repository(result.error))
            is Result.Success -> success(updated)
        }
    }

    sealed class Exception(message: String?, cause: Throwable?) :
        kotlin.Exception(message, cause) {
        object NoCurrentUser : Exception(
            message = "Current user was not present",
            cause = null,
        )
        data class NameAlreadyTaken(val name: Name) : Exception(
            message = """User with name "$name" already exists """,
            cause = null,
        )
        data class EmailAlreadyTaken(val email: Email) : Exception(
            message = """User with email "$email" already exists """,
            cause = null,
        )
        data class Repository(val error: BaseException) :
            Exception(error.message, error.cause)
    }
}
