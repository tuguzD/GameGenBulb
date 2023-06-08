package io.github.tuguzd.gamegenbulb.domain.usecase.system.user.current

import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.CurrentUserRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentUser(private val repository: CurrentUserRepository) {
    fun currentUser(): Flow<User?> = repository.read()
}
