package io.github.tuguzd.gamegenbulb.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.theme.AppTheme

@Composable
fun MainActivityContent(
    modifier: Modifier = Modifier,
) {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()

    AppTheme {
        Surface(modifier = modifier.fillMaxSize()) {
            val navGraph = NavGraphs.root
            val startRoute = navGraph.startRoute

            DestinationsNavHost(
                navGraph = navGraph,
                startRoute = startRoute,
                engine = engine,
                navController = navController,
            )
        }
    }
}
