package io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up.store

import com.arkivanov.mvikotlin.core.store.Store
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserCredentials
import io.github.tuguzd.gamegenbulb.domain.model.system.user.util.name.Name
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up.store.SignUpStore.*

interface SignUpStore : Store<Intent, State, Label> {
    sealed interface Intent {
        data class ChangeName(val name: String) : Intent
        data class ChangePassword(val password: String) : Intent
        data class ChangeRepeatPassword(val repeatPassword: String) : Intent
        data class ChangePasswordVisible(val passwordVisible: Boolean) : Intent
        data class SignUp(val credentials: UserCredentials) : Intent
    }

    data class State(
        val name: String,
        val password: String,
        val repeatPassword: String,
        val passwordVisible: Boolean,
        val valid: Boolean,
        val loading: Boolean,
    )

    sealed interface Label {
        data class NameAlreadyTaken(val name: Name) : Label
        object LocalStoreError : Label
        object NetworkAccessError : Label
        object UnknownError : Label
    }
}
