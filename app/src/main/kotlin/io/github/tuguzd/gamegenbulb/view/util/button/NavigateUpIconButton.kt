package io.github.tuguzd.gamegenbulb.view.util.button

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.tuguzd.gamegenbulb.R

@Composable
fun NavigateUpIconButton(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    imageVector: ImageVector = Icons.Rounded.ArrowBack,
    contentDescription: String = stringResource(R.string.navigate_up),
    beforeNavigation: () -> Unit = { },
) = TooltipIconButton(
    modifier = modifier,
    imageVector = imageVector,
    contentDescription = contentDescription,
) {
    beforeNavigation()
    navigator.navigateUp()
}
