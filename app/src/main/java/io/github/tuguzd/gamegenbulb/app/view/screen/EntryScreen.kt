package io.github.tuguzd.gamegenbulb.app.view.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.tuguzd.gamegenbulb.app.view.screen.main.list.MainScreen
import io.github.tuguzd.gamegenbulb.app.viewmodel.MainScreenViewModel

@Composable
fun EntryScreen(
    mainViewModel: MainScreenViewModel = viewModel(),
    navController: NavHostController =
        rememberNavController(),
) = Surface(color = MaterialTheme.colorScheme.background) {
    NavHost(navController = navController, startDestination = "main") {
        composable(route = "main") {
            MainScreen(
                state = mainViewModel.state,
                onGameClick = { game ->
                    navController.navigate(route = "game/${game.id}")
                },
            )
        }
        composable(route = "game/{id}") {
            Text("hehe")
        }
    }
}
