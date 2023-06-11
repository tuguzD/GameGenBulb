package io.github.tuguzd.gamegenbulb.view.screen.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppBottomBar
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppTopBar
import io.github.tuguzd.gamegenbulb.viewmodel.user.current.CurrentUserViewModel

@RootNavGraph(start = true)
@Destination
@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
    rootNavController: NavController,
    viewModel: CurrentUserViewModel,
) {
    val engine = rememberNavHostEngine()
    val appNavController = engine.rememberNavController()

    Scaffold(
        modifier = modifier,
        topBar = { AppTopBar(navController = rootNavController) },
        bottomBar = { AppBottomBar(navController = appNavController) },
    ) { padding ->
        DestinationsNavHost(
            modifier = Modifier.padding(padding),
            engine = engine,
            navController = appNavController,
            navGraph = NavGraphs.app,
            dependenciesContainerBuilder = {
                dependency(viewModel)
            }
        )
    }
}
