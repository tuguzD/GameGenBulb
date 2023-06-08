package io.github.tuguzd.gamegenbulb.domain.repository

import io.github.tuguzd.gamegenbulb.domain.model.util.exception.BaseException
import io.github.tuguzd.gamegenbulb.domain.model.util.result.Result

typealias RepositoryResult<T> = Result<T, BaseException>
