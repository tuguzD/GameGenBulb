package io.github.tuguzd.gamegenbulb.viewmodel.user.current.store

import com.arkivanov.mvikotlin.core.store.Store
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.store.CurrentUserStore.Intent
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.store.CurrentUserStore.Label
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.store.CurrentUserStore.State

interface CurrentUserStore : Store<Intent, State, Label> {
    sealed interface Intent {
        object SignOut : Intent
        object Delete : Intent
    }

    data class State(
        val currentUser: User?,
        val loading: Boolean,
    )

    sealed interface Label {
        data class SignedInUp(val currentUser: User) : Label
        object SignedOut : Label
        object LocalStoreError : Label
        object NetworkAccessError : Label
        object UnknownError : Label
    }
}
