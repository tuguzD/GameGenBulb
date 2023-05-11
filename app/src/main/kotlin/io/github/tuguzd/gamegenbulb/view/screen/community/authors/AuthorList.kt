package io.github.tuguzd.gamegenbulb.view.screen.community.authors

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.community.CommunityNavGraph

@CommunityNavGraph
@Destination
@Composable
fun AuthorListScreen() {
    Text(text = stringResource(R.string.authors))
}
