package io.github.tuguzd.gamegenbulb.viewmodel.user.current

import androidx.lifecycle.viewModelScope
import com.arkivanov.mvikotlin.core.store.StoreFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.current.DeleteCurrentUser
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.current.GetCurrentUser
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.sign.SignOut
import io.github.tuguzd.gamegenbulb.viewmodel.util.StoreViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.store.CurrentUserStore.*
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.store.CurrentUserStoreProvider
import javax.inject.Inject

@HiltViewModel
class CurrentUserViewModel @Inject constructor(
    currentUser: GetCurrentUser,
    signOut: SignOut,
    delete: DeleteCurrentUser,
    storeFactory: StoreFactory,
) : StoreViewModel<Intent, State, Label>() {
    override val provider = CurrentUserStoreProvider(
        currentUser = currentUser,
        signOut = signOut,
        delete = delete,
        storeFactory = storeFactory,
        coroutineContext = viewModelScope.coroutineContext,
    )
}
