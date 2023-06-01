package io.github.tuguzd.gamegenbulb.view.screen.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppBottomBar
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppTopBar

@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
) {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()

    Scaffold(
        modifier = modifier,
        topBar = { AppTopBar(navController = navController) },
        bottomBar = { AppBottomBar(navController = navController) },
    ) { padding ->
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(padding),
        )
    }
}
