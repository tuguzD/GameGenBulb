package io.github.tuguzd.gamegenbulb.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.destinations.AppScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.AuthScreenDestination
import io.github.tuguzd.gamegenbulb.view.theme.AppTheme
import io.github.tuguzd.gamegenbulb.view.util.collectInLaunchedEffectWithLifecycle
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.CurrentUserViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.store.CurrentUserStore

@Composable
fun MainActivityContent(
    modifier: Modifier = Modifier,
    viewModel: CurrentUserViewModel = hiltViewModel(),
) {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()

    viewModel.labels.collectInLaunchedEffectWithLifecycle block@{ label ->
        val direction = when (label) {
            is CurrentUserStore.Label.SignedInUp -> AppScreenDestination()
            CurrentUserStore.Label.SignedOut -> AuthScreenDestination()
            else -> return@block
        }
        navController.navigate(direction) {
            popUpTo(NavGraphs.root) { inclusive = true }
        }
    }

    AppTheme {
        Surface(modifier = modifier.fillMaxSize()) {
            val navGraph = NavGraphs.root
            val startRoute = run {
                if (viewModel.stateFlow.value.currentUser == null)
                    AuthScreenDestination
                else navGraph.startRoute
            }

            DestinationsNavHost(
                navGraph = navGraph,
                startRoute = startRoute,
                engine = engine,
                navController = navController,
                dependenciesContainerBuilder = {
                    dependency(viewModel)
                }
            )
        }
    }
}
