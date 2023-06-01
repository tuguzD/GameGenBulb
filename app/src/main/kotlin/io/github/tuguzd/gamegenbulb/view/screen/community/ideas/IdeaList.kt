package io.github.tuguzd.gamegenbulb.view.screen.community.ideas

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.community.util.CommunityNavGraph

@CommunityNavGraph(start = true)
@Destination
@Composable
fun IdeaListScreen(
    modifier: Modifier = Modifier,
) {
    Text(text = stringResource(R.string.ideas))
}
