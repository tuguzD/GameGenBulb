package io.github.tuguzd.gamegenbulb.domain.usecase.system.user.sign

import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserCredentials
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserDataFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserFilters
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

class SignUp(
    private val userRepository: UserRepository,
    private val currentUserRepository: CurrentUserRepository,
) {
    suspend fun signUp(credentials: UserCredentials): Result<User, Exception> {
        val currentUser = currentUserRepository.read().firstOrNull()
        if (currentUser != null) {
            return error(Exception.AlreadySignedIn(currentUser))
        }

        val name = credentials.name
        val dataFilters = UserDataFilters(name = NameFilters(eq = Equal(name)))
        val filters = UserFilters(data = dataFilters)
        val user = when (val result = userRepository.read(filters)) {
            is Result.Error -> return error(Exception.Repository(result.error))
            is Result.Success -> result.data.firstOrNull()?.firstOrNull()
        }
        if (user != null) {
            return error(Exception.NameAlreadyTaken(name))
        }

        val signedUp = when (val result = userRepository.signUp(credentials)) {
            is Result.Error -> return error(Exception.Repository(result.error))
            is Result.Success -> result.data
        }
        return when (val result = currentUserRepository.set(signedUp)) {
            is Result.Error -> error(Exception.Repository(result.error))
            is Result.Success -> success(signedUp)
        }
    }

    sealed class Exception(message: String?, cause: Throwable?)
        : kotlin.Exception(message, cause) {
        data class NameAlreadyTaken(val name: Name) : Exception(
            message = """User with name "$name" already exists """,
            cause = null,
        )
        data class AlreadySignedIn(val user: User) : Exception(
            message = """User $user is already signed in the system""",
            cause = null,
        )
        data class Repository(val error: BaseException) :
            Exception(error.message, error.cause)
    }
}
