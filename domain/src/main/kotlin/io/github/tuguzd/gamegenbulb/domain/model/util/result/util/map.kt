package io.github.tuguzd.gamegenbulb.domain.model.util.result.util

import io.github.tuguzd.gamegenbulb.domain.model.util.result.Result
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun <T, E, U> Result<T, E>.map(transform: (T) -> U): Result<U, E> {
    contract {
        callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when (this) {
        is Result.Success -> map(transform)
        is Result.Error -> map(transform)
    }
}

@OptIn(ExperimentalContracts::class)
fun <T, E, U> Result.Success<T, E>.map(transform: (T) -> U): Result.Success<U, E> {
    contract {
        callsInPlace(transform, InvocationKind.EXACTLY_ONCE)
    }
    return Result.Success(data = transform(data))
}

@OptIn(ExperimentalContracts::class)
fun <T, E, U> Result.Error<T, E>.map(transform: (T) -> U): Result.Error<U, E> {
    contract {
        callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return Result.Error(error = error, data = data?.let(transform))
}
