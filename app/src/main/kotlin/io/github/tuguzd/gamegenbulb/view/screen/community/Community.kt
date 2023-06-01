package io.github.tuguzd.gamegenbulb.view.screen.community

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SdCard
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.appCurrentDestinationAsState
import io.github.tuguzd.gamegenbulb.view.screen.startAppDestination

@RootNavGraph(start = true)
@Destination
@Composable
fun CommunityScreen() {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()

    Column {
        CommunityTabRow(navController)
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.community,
        )
    }
}

@Composable
fun CommunityTabRow(
    navController: NavController,
) {
    val currentDestination =
        navController.appCurrentDestinationAsState().value
            ?: NavGraphs.community.startAppDestination

    val index = CommunityDestination.values()
        .indexOfFirst { it.direction == currentDestination }

    var state by remember(index) { mutableStateOf(index) }

    TabRow(selectedTabIndex = state) {
        CommunityDestination.values().forEachIndexed { index, destination ->
            val selected = state == index
            CommunityIconTab(destination, selected) {
                if (!selected) {
                    state = index
                    navController.navigate(destination.direction)
                }
            }
        }
    }
}

@Composable
private fun CommunityIconTab(
    destination: CommunityDestination,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val label = stringResource(destination.label)
    LeadingIconTab(
        selected = selected, onClick = onClick,
        text = { Text(text = label) },
        icon = { Icon(Icons.Filled.SdCard, label) },
    )
}
