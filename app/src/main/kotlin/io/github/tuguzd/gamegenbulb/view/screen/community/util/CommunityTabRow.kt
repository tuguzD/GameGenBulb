package io.github.tuguzd.gamegenbulb.view.screen.community.util

import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.appCurrentDestinationAsState
import io.github.tuguzd.gamegenbulb.view.screen.startAppDestination

@Composable
fun CommunityTabRow(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val currentDestination =
        navController.appCurrentDestinationAsState().value
            ?: NavGraphs.community.startAppDestination

    val index = CommunityDestination.values()
        .indexOfFirst { it.direction == currentDestination }

    var state by remember(index) { mutableStateOf(index) }

    TabRow(
        modifier = modifier,
        selectedTabIndex = state,
    ) {
        CommunityDestination.values().forEachIndexed { index, destination ->
            CommunityIconTab(
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
