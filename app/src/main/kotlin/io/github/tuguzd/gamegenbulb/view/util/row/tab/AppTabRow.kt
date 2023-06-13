package io.github.tuguzd.gamegenbulb.view.util.row.tab

import androidx.compose.material3.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import io.github.tuguzd.gamegenbulb.view.screen.NavGraph
import io.github.tuguzd.gamegenbulb.view.screen.appCurrentDestinationAsState
import io.github.tuguzd.gamegenbulb.view.screen.destinations.Destination
import io.github.tuguzd.gamegenbulb.view.screen.startAppDestination
import io.github.tuguzd.gamegenbulb.view.util.UtilDestination

@Composable
fun <D : UtilDestination> AppTabRow(
    navGraph: NavGraph,
    navController: NavController,
    isPrimary: Boolean,
    isScrollable: Boolean,
    destinations: Array<D>,
    modifier: Modifier = Modifier,
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
        isScrollable = isScrollable,
        indicator = @Composable { tabPositions: List<TabPosition> ->
            TabRowIndicator(
                isPrimary = isPrimary,
                destination = destinations[state],
                tabPosition = tabPositions[state],
            )
        },
    ) {
        destinations.forEachIndexed { index, destination ->
            IconTab(
                isPrimary = isPrimary,
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
