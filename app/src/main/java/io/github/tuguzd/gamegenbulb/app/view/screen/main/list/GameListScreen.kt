package io.github.tuguzd.gamegenbulb.app.view.screen.main.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import io.github.tuguzd.gamegenbulb.app.R
import io.github.tuguzd.gamegenbulb.app.viewmodel.main.list.GameListState
import io.github.tuguzd.gamegenbulb.domain.model.content.Game

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameListScreen(
    state: GameListState,
    onGameClick: (Game) -> Unit,
) = Scaffold(
    topBar = {
        TopAppBar(title = {
            Text(text = stringResource(R.string.app_name))
        })
    },
) { padding ->
    GameList(
        state = state,
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        onGameClick = onGameClick,
    )
}

@Composable
private fun GameList(
    state: GameListState,
    modifier: Modifier,
    onGameClick: (Game) -> Unit,
) {
    // TODO fix restarting view model on navigation
    val games = state.games.collectAsLazyPagingItems()

    // TODO fix duplicate items in list
    // (API send items in different order each time,
    // so it looks like it's needed to cache items and
    // with each response check if item is already in list
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(games) { game ->
            game?.let {
                GameCard(
                    game = game,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onGameClick(game) },
                )
            }
        }
    }
}
