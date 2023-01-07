package io.github.tuguzd.gamegenbulb.app.view.screen.main.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.app.R
import io.github.tuguzd.gamegenbulb.app.viewmodel.MainScreenState
import io.github.tuguzd.gamegenbulb.domain.model.content.Game

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    state: MainScreenState,
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
    state: MainScreenState,
    modifier: Modifier,
    onGameClick: (Game) -> Unit,
) = LazyColumn(
    modifier = modifier,
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
) {
    items(state.games, key = { it.id.toString() }) { game ->
        GameCard(
            game = game,
            modifier = Modifier.fillMaxWidth(),
            onClick = { onGameClick(game) },
        )
    }
}
