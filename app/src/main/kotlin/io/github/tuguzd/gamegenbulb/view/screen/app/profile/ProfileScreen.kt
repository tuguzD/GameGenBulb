package io.github.tuguzd.gamegenbulb.view.screen.app.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.tuguzd.gamegenbulb.view.screen.app.profile.util.UserContent
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppNavGraph
import io.github.tuguzd.gamegenbulb.view.util.collectInLaunchedEffectWithLifecycle
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.CurrentUserViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.store.CurrentUserStore

@AppNavGraph
@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    currentUserViewModel: CurrentUserViewModel,
) {
    val state by currentUserViewModel.stateFlow.collectAsStateWithLifecycle()
    currentUserViewModel.labels.collectInLaunchedEffectWithLifecycle { label ->
        // TODO show error to user before navigate up
        when (label) {
            CurrentUserStore.Label.LocalStoreError -> navigator.navigateUp()
            CurrentUserStore.Label.NetworkAccessError -> navigator.navigateUp()
            is CurrentUserStore.Label.SignedInUp -> navigator.navigateUp()
            CurrentUserStore.Label.SignedOut -> navigator.navigateUp()
            CurrentUserStore.Label.UnknownError -> navigator.navigateUp()
        }
    }
    UserContent(user = state.currentUser)
}
