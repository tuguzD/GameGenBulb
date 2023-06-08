package io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up

import androidx.lifecycle.viewModelScope
import com.arkivanov.mvikotlin.core.store.StoreFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.sign.SignUp
import io.github.tuguzd.gamegenbulb.viewmodel.util.StoreViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up.store.SignUpStore.*
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up.store.SignUpStoreProvider
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    signUp: SignUp,
    storeFactory: StoreFactory,
) : StoreViewModel<Intent, State, Label>() {
    override val provider = SignUpStoreProvider(
        signUp = signUp,
        storeFactory = storeFactory,
        coroutineContext = viewModelScope.coroutineContext,
    )
}
