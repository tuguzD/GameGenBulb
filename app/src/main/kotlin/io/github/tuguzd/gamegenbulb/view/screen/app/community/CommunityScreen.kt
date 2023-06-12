package io.github.tuguzd.gamegenbulb.view.screen.app.community

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.app.community.util.CommunityDestination
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppNavGraph
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppTabRow

@AppNavGraph(start = true)
@Destination
@Composable
fun CommunityScreen(
    modifier: Modifier = Modifier,
) {
    val engine = rememberNavHostEngine()
    val navGraph = NavGraphs.community
    val navController = engine.rememberNavController()

    Column(modifier = modifier.fillMaxSize()) {
        AppTabRow(
            navGraph = navGraph,
            navController = navController,
            destinations = CommunityDestination.values(),
        )
        DestinationsNavHost(
            engine = engine,
            navGraph = navGraph,
            navController = navController,
        )
    }
}
