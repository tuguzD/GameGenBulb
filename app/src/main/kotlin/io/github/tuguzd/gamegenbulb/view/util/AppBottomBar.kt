package io.github.tuguzd.gamegenbulb.view.util

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import io.github.tuguzd.gamegenbulb.view.screen.AppDestination
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs

@Composable
fun AppBottomBar(
    navController: NavHostController,
) = NavigationBar {
    AppDestination.values().forEach { destination ->
        AppBottomBarItem(destination, navController)
    }
}

@Composable
fun RowScope.AppBottomBarItem(
    destination: AppDestination,
    navController: NavHostController,
) {
    val isCurrDestOnBackStack =
        navController.isRouteOnBackStack(destination.direction)
    val label = stringResource(destination.label)

    NavigationBarItem(
        selected = isCurrDestOnBackStack,
        onClick = { onItemClick(destination, navController, isCurrDestOnBackStack) },
        icon = { Icon(destination.icon, label) },
        label = { Text(label) },
    )
}

private fun onItemClick(
    destination: AppDestination,
    navController: NavHostController,
    isCurrDestOnBackStack: Boolean,
) {
    if (isCurrDestOnBackStack) {
        // When we click again on a bottom bar item and
        // it was already selected we want to pop the back stack
        // until the initial destination of this bottom bar item
        navController.popBackStack(destination.direction, false)
        return
    }
    navController.navigate(destination.direction) {
        // Pop up to the root of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(NavGraphs.root) { saveState = true }
        // Avoid multiple copies of the same destination
        // when re-selecting the same item
        launchSingleTop = true
        // Restore state when re-selecting a previously selected item
        restoreState = true
    }
}
