package io.github.tuguzd.gamegenbulb.viewmodel.user.data.store

import com.arkivanov.mvikotlin.core.store.Store
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserId
import io.github.tuguzd.gamegenbulb.viewmodel.user.data.store.UserStore.*

interface UserStore : Store<Intent, State, Label> {
    sealed interface Intent {
        data class Load(val id: UserId) : Intent
    }

    data class State(
        val user: User?,
        val loading: Boolean,
    )

    sealed interface Label {
        data class NotFound(val id: UserId) : Label
        object LocalStoreError : Label
        object NetworkAccessError : Label
        object UnknownError : Label
    }
}
