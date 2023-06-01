package io.github.tuguzd.gamegenbulb.view.screen.community

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.community.util.CommunityTabRow

@RootNavGraph(start = true)
@Destination
@Composable
fun CommunityScreen(
    modifier: Modifier = Modifier,
) {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()

    Column(modifier = modifier) {
        CommunityTabRow(navController = navController)
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.community,
        )
    }
}
