package io.github.tuguzd.gamegenbulb.viewmodel.user.update.store

import com.arkivanov.mvikotlin.core.store.Store
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.avatar.Avatar
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.display.DisplayName
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.email.Email
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name.Name
import io.github.tuguzd.gamegenbulb.viewmodel.user.update.store.UpdateUserStore.Intent
import io.github.tuguzd.gamegenbulb.viewmodel.user.update.store.UpdateUserStore.Label
import io.github.tuguzd.gamegenbulb.viewmodel.user.update.store.UpdateUserStore.State

interface UpdateUserStore : Store<Intent, State, Label> {
    sealed interface Intent {
        data class ChangeName(val name: Name) : Intent
        data class ChangeDisplayName(val displayName: DisplayName) : Intent
        data class ChangeEmail(val email: Email?) : Intent
        data class ChangeAvatar(val avatar: Avatar?) : Intent
        object UpdateUser : Intent
    }

    data class State(
        val name: Name,
        val displayName: DisplayName,
        val email: Email?,
        val avatar: Avatar?,
        val valid: Boolean,
        val loading: Boolean,
    )

    sealed interface Label {
        object UserUpdated : Label
        object NoCurrentUser : Label
        data class NameAlreadyTaken(val name: Name) : Label
        data class EmailAlreadyTaken(val email: Email) : Label
        object LocalStoreError : Label
        object NetworkAccessError : Label
        object UnknownError : Label
    }
}
