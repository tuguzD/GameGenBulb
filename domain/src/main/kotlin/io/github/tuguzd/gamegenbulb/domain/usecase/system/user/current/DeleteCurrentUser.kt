package io.github.tuguzd.gamegenbulb.domain.usecase.system.user.current

import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserIdFilters
import io.github.tuguzd.gamegenbulb.domain.model.util.exception.BaseException
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.Equal
import io.github.tuguzd.gamegenbulb.domain.model.util.result.Result
import io.github.tuguzd.gamegenbulb.domain.model.util.result.error
import io.github.tuguzd.gamegenbulb.domain.model.util.result.success
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.CurrentUserRepository
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.UserRepository
import kotlinx.coroutines.flow.firstOrNull

class DeleteCurrentUser(
    private val userRepository: UserRepository,
    private val currentUserRepository: CurrentUserRepository,
) {
    suspend fun delete(): Result<User, Exception> {
        val currentUser = currentUserRepository.read().firstOrNull()
            ?: return error(Exception.NoCurrentUser)
        val id = currentUser.id

        val filters = UserFilters(id = UserIdFilters(eq = Equal(id)))
        val user = when (val result = userRepository.read(filters)) {
            is Result.Error -> return error(Exception.Repository(result.error))
            is Result.Success -> result.data.firstOrNull()?.firstOrNull()
        }
        user ?: return error(Exception.NoCurrentUser)

        val deleted = when (val result = userRepository.delete(id)) {
            is Result.Error -> return error(Exception.Repository(result.error))
            is Result.Success -> result.data
        }
        return when (val result = currentUserRepository.set(null)) {
            is Result.Error -> error(Exception.Repository(result.error))
            is Result.Success -> success(deleted)
        }
    }

    sealed class Exception(message: String?, cause: Throwable?) :
        kotlin.Exception(message, cause) {
        object NoCurrentUser : Exception(
            message = "Current user was not present",
            cause = null,
        )
        data class Repository(val error: BaseException) :
            Exception(error.message, error.cause)
    }
}
