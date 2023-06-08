package io.github.tuguzd.gamegenbulb.domain.model.util.result.util

import io.github.tuguzd.gamegenbulb.domain.model.util.result.Result
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun <T, E, N> Result<T, E>.mapError(transform: (E) -> N): Result<T, N> {
    contract {
        callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return when (this) {
        is Result.Success -> mapError(transform)
        is Result.Error -> mapError(transform)
    }
}

@OptIn(ExperimentalContracts::class)
fun <T, E, N> Result.Success<T, E>.mapError(transform: (E) -> N): Result.Success<T, N> {
    contract {
        callsInPlace(transform, InvocationKind.AT_MOST_ONCE)
    }
    return Result.Success(data = data)
}

@OptIn(ExperimentalContracts::class)
fun <T, E, N> Result.Error<T, E>.mapError(transform: (E) -> N): Result.Error<T, N> {
    contract {
        callsInPlace(transform, InvocationKind.EXACTLY_ONCE)
    }
    return Result.Error(error = transform(error), data = data)
}
