package io.github.tuguzd.gamegenbulb.view.screen.app.workshop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppNavGraph
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppTabRow
import io.github.tuguzd.gamegenbulb.view.screen.app.workshop.util.WorkshopDestination

@AppNavGraph
@Destination
@Composable
fun WorkshopScreen(
    modifier: Modifier = Modifier,
) {
    val engine = rememberNavHostEngine()
    val navGraph = NavGraphs.workshop
    val navController = engine.rememberNavController()

    Column(modifier = modifier.fillMaxSize()) {
        AppTabRow(
            navGraph = navGraph,
            navController = navController,
            isPrimary = false,
            destinations = WorkshopDestination.values(),
        )
        DestinationsNavHost(
            engine = engine,
            navGraph = navGraph,
            navController = navController,
        )
    }
}
