package io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_in

import androidx.lifecycle.viewModelScope
import com.arkivanov.mvikotlin.core.store.StoreFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.sign.SignIn
import io.github.tuguzd.gamegenbulb.viewmodel.util.StoreViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_in.store.SignInStore.Intent
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_in.store.SignInStore.Label
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_in.store.SignInStore.State
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_in.store.SignInStoreProvider
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    signIn: SignIn,
    storeFactory: StoreFactory,
) : StoreViewModel<Intent, State, Label>() {
    override val provider = SignInStoreProvider(
        signIn = signIn,
        storeFactory = storeFactory,
        coroutineContext = viewModelScope.coroutineContext,
    )
}
