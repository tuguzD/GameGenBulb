package io.github.tuguzd.gamegenbulb.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.util.AppBottomBar
import io.github.tuguzd.gamegenbulb.view.theme.AppTheme
import io.github.tuguzd.gamegenbulb.view.util.AppScaffold
import io.github.tuguzd.gamegenbulb.view.util.AppTopBar

@Composable
fun MainActivityContent() = AppTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
        RootScreen()
    }
}

@Composable
fun RootScreen() {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()

    val startRoute = NavGraphs.root.startRoute

    AppScaffold(
        startRoute = startRoute,
        navController = navController,
        topBar = { AppTopBar() },
        bottomBar = { AppBottomBar(navController) },
    ) { padding ->
        DestinationsNavHost(
            engine = engine,
            startRoute = startRoute,
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(padding),
        )
    }
}
