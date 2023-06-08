package io.github.tuguzd.gamegenbulb.viewmodel.user.data

import androidx.lifecycle.viewModelScope
import com.arkivanov.mvikotlin.core.store.StoreFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.FilterUsers
import io.github.tuguzd.gamegenbulb.viewmodel.util.StoreViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.user.data.store.UserStore.*
import io.github.tuguzd.gamegenbulb.viewmodel.user.data.store.UserStoreProvider
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    users: FilterUsers,
    storeFactory: StoreFactory,
) : StoreViewModel<Intent, State, Label>() {
    override val provider = UserStoreProvider(
        users = users,
        storeFactory = storeFactory,
        coroutineContext = viewModelScope.coroutineContext,
    )
}
