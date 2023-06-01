package io.github.tuguzd.gamegenbulb.view.util

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.ramcosta.composedestinations.navigation.navigate
import io.github.tuguzd.gamegenbulb.view.screen.AppDestination
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.appCurrentDestinationAsState
import io.github.tuguzd.gamegenbulb.view.screen.destinations.Destination
import io.github.tuguzd.gamegenbulb.view.screen.startAppDestination

@Composable
fun AppBottomBar(
    navController: NavController,
) {
    val currentDestination: Destination =
        navController.appCurrentDestinationAsState().value
            ?: NavGraphs.root.startAppDestination

    NavigationBar {
        AppDestination.values().forEach { destination ->
            AppBottomBarItem(destination, currentDestination, navController)
        }
    }
}

@Composable
private fun RowScope.AppBottomBarItem(
    destination: AppDestination,
    currentDestination: Destination,
    navController: NavController,
) {
    val label = stringResource(destination.label)

    NavigationBarItem(
        selected = currentDestination == destination.direction,
        onClick = {
            navController.navigate(
                direction = destination.direction,
                navOptionsBuilder = fun NavOptionsBuilder.() {
                    launchSingleTop = true
                },
            )
        },
        icon = { Icon(destination.icon, label) },
        label = { Text(label) },
    )
}
