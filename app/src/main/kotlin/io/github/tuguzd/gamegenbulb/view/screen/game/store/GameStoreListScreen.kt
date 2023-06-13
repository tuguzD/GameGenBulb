package io.github.tuguzd.gamegenbulb.view.screen.game.store

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.game.util.GameNavGraph

@GameNavGraph
@Destination
@Composable
fun GameStoreListScreen(
    modifier: Modifier = Modifier,
) = Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(text = stringResource(R.string.store_list))
}
