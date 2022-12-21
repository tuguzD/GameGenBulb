package io.github.tuguzd.gamegenbulb.data.datasource.remote.util

import com.haroldadmin.cnradapter.CompletableResponse
import com.haroldadmin.cnradapter.NetworkResponse
import io.github.tuguzd.gamegenbulb.domain.util.DomainError
import io.github.tuguzd.gamegenbulb.domain.util.DomainResult
import io.github.tuguzd.gamegenbulb.domain.util.success

internal typealias ApiResponse<T> = NetworkResponse<T, ApiError>

internal typealias ApiCompletableResponse = CompletableResponse<ApiError>

internal fun <T> ApiResponse<T>.toResult(): DomainResult<T> = when (this) {
    is NetworkResponse.Success -> success(body)
    is NetworkResponse.ServerError -> error(DomainError.LogicError(body?.text, error))
    is NetworkResponse.NetworkError -> error(DomainError.NetworkError(body?.text, error))
    is NetworkResponse.UnknownError -> error(DomainError.UnknownError(body?.text, error))
}
