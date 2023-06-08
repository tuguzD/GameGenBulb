package io.github.tuguzd.gamegenbulb.viewmodel.user.update

import androidx.lifecycle.viewModelScope
import com.arkivanov.mvikotlin.core.store.StoreFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.current.GetCurrentUser
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.current.UpdateCurrentUser
import io.github.tuguzd.gamegenbulb.viewmodel.util.StoreViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.user.update.store.UpdateUserStore.*
import io.github.tuguzd.gamegenbulb.viewmodel.user.update.store.UpdateUserStoreProvider
import javax.inject.Inject

@HiltViewModel
class UpdateUserViewModel @Inject constructor(
    currentUser: GetCurrentUser,
    updateUser: UpdateCurrentUser,
    storeFactory: StoreFactory,
) : StoreViewModel<Intent, State, Label>() {
    override val provider = UpdateUserStoreProvider(
        currentUser = currentUser,
        updateUser = updateUser,
        storeFactory = storeFactory,
        coroutineContext = viewModelScope.coroutineContext,
    )
}
