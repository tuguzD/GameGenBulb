package io.github.tuguzd.gamegenbulb.view.screen.app.util

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.ramcosta.composedestinations.navigation.navigate
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.appCurrentDestinationAsState
import io.github.tuguzd.gamegenbulb.view.screen.destinations.Destination
import io.github.tuguzd.gamegenbulb.view.screen.startAppDestination

@Composable
fun AppBottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val currentDestination: Destination =
        navController.appCurrentDestinationAsState().value
            ?: NavGraphs.app.startAppDestination

    NavigationBar(
        modifier = modifier,
    ) {
        AppDestination.values().forEach { destination ->
            AppBottomBarItem(
                destination = destination,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
private fun RowScope.AppBottomBarItem(
    modifier: Modifier = Modifier,
    destination: AppDestination,
    currentDestination: Destination,
    navController: NavController,
) {
    val label = stringResource(destination.label)

    NavigationBarItem(
        modifier = modifier,
        selected = currentDestination == destination.direction,
        onClick = {
            navController.navigate(
                direction = destination.direction,
                navOptionsBuilder = fun NavOptionsBuilder.() {
                    launchSingleTop = true
                },
            )
        },
        icon = { Icon(imageVector = destination.icon, contentDescription = label) },
        label = { Text(text = label) },
    )
}
