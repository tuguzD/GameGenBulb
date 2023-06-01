package io.github.tuguzd.gamegenbulb.view.screen.app

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.spec.Route
import io.github.tuguzd.gamegenbulb.view.screen.appCurrentDestinationAsState
import io.github.tuguzd.gamegenbulb.view.screen.destinations.Destination
import io.github.tuguzd.gamegenbulb.view.screen.startAppDestination

@Composable
fun AppScaffold(
    startRoute: Route,
    navController: NavHostController,
//    topBar: @Composable (Destination, NavBackStackEntry?) -> Unit,
    topBar: @Composable () -> Unit,
    bottomBar: @Composable (Destination) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val destination = navController.appCurrentDestinationAsState().value
        ?: startRoute.startAppDestination
//    val navBackStackEntry = navController.currentBackStackEntry

    Scaffold(
        topBar = {
//            topBar(destination, navBackStackEntry)
            topBar()
        },
        bottomBar = { bottomBar(destination) },
        content = content,
    )
}
