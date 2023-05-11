package io.github.tuguzd.gamegenbulb.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.root.BottomBar
import io.github.tuguzd.gamegenbulb.view.theme.AppTheme
import io.github.tuguzd.gamegenbulb.view.util.TopBar

@Composable
fun MainActivityContent() = AppTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
        BasicScreen()
    }
}

@Composable
fun BasicScreen() {
    val engine = rememberNavHostEngine()
    val navController = engine.rememberNavController()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController) },
    ) { padding ->
        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(padding),
        )
    }
}
