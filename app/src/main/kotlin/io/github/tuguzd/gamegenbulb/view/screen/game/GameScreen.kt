package io.github.tuguzd.gamegenbulb.view.screen.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.rememberNavHostEngine
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.game.util.GameDestination
import io.github.tuguzd.gamegenbulb.view.util.button.FavouriteIconButton
import io.github.tuguzd.gamegenbulb.view.util.button.TooltipIconButton
import io.github.tuguzd.gamegenbulb.view.util.card.Game
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.ContentImage
import io.github.tuguzd.gamegenbulb.view.util.row.tab.AppTabRow
import io.github.tuguzd.gamegenbulb.view.util.topbar.NavigateUpMediumTopBar

@RootNavGraph
@Destination
@Composable
fun GameScreen(
    game: Game,
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
) = Scaffold(
    modifier = modifier,
    topBar = {
        NavigateUpMediumTopBar(
            title = game.name,
            navigator = navigator,
        ) {
            var isFavourite by remember { mutableStateOf(false) }
            FavouriteIconButton(isFavourite) {
                isFavourite = !isFavourite
            }
            TooltipIconButton(
                imageVector = Icons.Rounded.Share,
                contentDescription = stringResource(R.string.share),
            )
        }
    },
) { padding ->
    val engine = rememberNavHostEngine()
    val navGraph = NavGraphs.game
    val navController = engine.rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
    ) {
        ContentImage(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
            contentImage = game.imagePath,
        )
        AppTabRow(
            navGraph = navGraph,
            navController = navController,
            isPrimary = true,
            isScrollable = true,
            destinations = GameDestination.values(),
        )
        DestinationsNavHost(
            engine = engine,
            navGraph = navGraph,
            navController = navController,
        )
    }
}
