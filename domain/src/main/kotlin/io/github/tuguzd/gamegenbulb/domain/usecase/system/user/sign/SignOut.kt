package io.github.tuguzd.gamegenbulb.domain.usecase.system.user.sign

import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.util.exception.BaseException
import io.github.tuguzd.gamegenbulb.domain.model.util.result.Result
import io.github.tuguzd.gamegenbulb.domain.model.util.result.error
import io.github.tuguzd.gamegenbulb.domain.model.util.result.success
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.CurrentUserRepository
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.UserRepository
import kotlinx.coroutines.flow.firstOrNull

class SignOut(
    private val userRepository: UserRepository,
    private val currentUserRepository: CurrentUserRepository,
) {
    suspend fun signOut(): Result<User, Exception> {
        val currentUser = currentUserRepository.read().firstOrNull()
            ?: return error(Exception.NotSignedIn)

        val signedOut = when (val result = userRepository.signOut(currentUser.id)) {
            is Result.Error -> return error(Exception.Repository(result.error))
            is Result.Success -> result.data
        }
        return when (val result = currentUserRepository.set(null)) {
            is Result.Error -> error(Exception.Repository(result.error))
            is Result.Success -> success(signedOut)
        }
    }

    sealed class Exception(message: String?, cause: Throwable?) :
        kotlin.Exception(message, cause) {
        object NotSignedIn : Exception(
            message = "User was not signed in the system",
            cause = null,
        )
        data class Repository(val error: BaseException) :
            Exception(error.message, error.cause)
    }
}
