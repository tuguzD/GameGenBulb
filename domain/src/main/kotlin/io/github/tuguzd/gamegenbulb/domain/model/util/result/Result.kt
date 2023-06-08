package io.github.tuguzd.gamegenbulb.domain.model.util.result

sealed interface Result<T, E> {
    val data: T?
    val error: E?

    data class Success<T, E>(
        override val data: T,
    ) : Result<T, E> {
        override val error = null
    }

    data class Error<T, E>(
        override val error: E,
        override val data: T? = null,
    ) : Result<T, E>
}

fun <T, E> success(data: T): Result.Success<T, E> = Result.Success(data)

fun <T, E> error(error: E, data: T? = null): Result.Error<T, E> =
    Result.Error(error, data)
