package io.github.tuguzd.gamegenbulb.view.screen.app.util

import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import io.github.tuguzd.gamegenbulb.view.screen.NavGraph
import io.github.tuguzd.gamegenbulb.view.screen.appCurrentDestinationAsState
import io.github.tuguzd.gamegenbulb.view.screen.destinations.Destination
import io.github.tuguzd.gamegenbulb.view.screen.startAppDestination
import io.github.tuguzd.gamegenbulb.view.util.UtilDestination

@Composable
fun <D : UtilDestination> AppTabRow(
    modifier: Modifier = Modifier,
    navGraph: NavGraph,
    navController: NavController,
    destinations: Array<D>,
) {
    val currentDestination: Destination =
        navController.appCurrentDestinationAsState().value
            ?: navGraph.startAppDestination

    val index = destinations.indexOfFirst {
        it.direction == currentDestination
    }
    var state by remember(index) { mutableStateOf(index) }

    TabRow(
        modifier = modifier,
        selectedTabIndex = state,
    ) {
        destinations.forEachIndexed { index, destination ->
            AppIconTab(
                destination = destination,
                selected = state == index,
            ) {
                state = index
                navController.navigate(destination.direction) {
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }
}

@Composable
private fun <D : UtilDestination> AppIconTab(
    modifier: Modifier = Modifier,
    destination: D,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val label = stringResource(destination.label)
    LeadingIconTab(
        modifier = modifier,
        selected = selected, onClick = onClick,
        text = { Text(text = label) },
        icon = { Icon(destination.icon, label) },
    )
}
