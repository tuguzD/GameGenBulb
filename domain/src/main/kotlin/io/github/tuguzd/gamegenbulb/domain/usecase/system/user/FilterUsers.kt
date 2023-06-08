package io.github.tuguzd.gamegenbulb.domain.usecase.system.user

import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserFilters
import io.github.tuguzd.gamegenbulb.domain.model.util.exception.BaseException
import io.github.tuguzd.gamegenbulb.domain.model.util.result.Result
import io.github.tuguzd.gamegenbulb.domain.model.util.result.error
import io.github.tuguzd.gamegenbulb.domain.model.util.result.success
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.UserRepository
import kotlinx.coroutines.flow.Flow

class FilterUsers(private val repository: UserRepository) {
    suspend fun users(filters: UserFilters): Result<Flow<List<User>>, Exception> {
        return when (val result = repository.read(filters)) {
            is Result.Error -> error(Exception.Repository(result.error))
            is Result.Success -> success(result.data)
        }
    }

    sealed class Exception(message: String?, cause: Throwable?) :
        kotlin.Exception(message, cause) {
        data class Repository(val error: BaseException) :
            Exception(error.message, error.cause)
    }
}
