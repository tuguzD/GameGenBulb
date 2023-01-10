package io.github.tuguzd.gamegenbulb.app.view.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.tuguzd.gamegenbulb.app.view.screen.main.list.GameListScreen
import io.github.tuguzd.gamegenbulb.app.viewmodel.main.list.GameListViewModel

@Composable
fun EntryScreen(
    mainViewModel: GameListViewModel = viewModel(),
    navController: NavHostController =
        rememberNavController(),
) = Surface(color = MaterialTheme.colorScheme.background) {
    NavHost(navController = navController, startDestination = "community") {
        composable(route = "community") {
            GameListScreen(
                state = mainViewModel.state,
                onGameClick = {
                    //game -> navController.navigate(route = "game/${game.id}")
                },
            )
        }
        //composable(route = "game/{id}") {
        //    Text("hehe")
        //}
    }
}
