package io.github.tuguzd.gamegenbulb.domain.model.util.exception

sealed class BaseException(message: String?, cause: Throwable?) : Exception(message, cause) {
    class LocalStore(cause: Throwable? = null) :
        BaseException(message = "Local database error", cause)

    class NetworkAccess(cause: Throwable? = null) :
        BaseException(message = "Network access error", cause)

    class Unknown(cause: Throwable) :
        BaseException(message = "Unknown kind error", cause)
}
