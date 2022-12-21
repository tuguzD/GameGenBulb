package io.github.tuguzd.gamegenbulb.data.datasource.remote.util

import kotlinx.serialization.Serializable

@JvmInline
@Serializable
internal value class ApiError(val text: String)
