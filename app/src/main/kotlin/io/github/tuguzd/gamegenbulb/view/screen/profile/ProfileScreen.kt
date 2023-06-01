package io.github.tuguzd.gamegenbulb.view.screen.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import io.github.tuguzd.gamegenbulb.R

@RootNavGraph
@Destination
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Text(text = stringResource(R.string.user_profile))
}
