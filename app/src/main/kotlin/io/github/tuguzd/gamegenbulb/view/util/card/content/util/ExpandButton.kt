package io.github.tuguzd.gamegenbulb.view.util.card.content.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Fullscreen
import androidx.compose.material.icons.rounded.FullscreenExit
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.button.TooltipIconButton

@Composable
fun ExpandButton(
    expandedState: Boolean,
    onClick: () -> Unit,
) {
    val expandIcon =
        if (!expandedState) Icons.Rounded.Fullscreen
        else Icons.Rounded.FullscreenExit
    val expandLabel = stringResource(
        if (expandedState) R.string.shrink
        else R.string.expand
    )
    val expandColors =
        if (!expandedState) IconButtonDefaults.iconButtonColors()
        else IconButtonDefaults.filledTonalIconButtonColors()

    TooltipIconButton(
        imageVector = expandIcon,
        contentDescription = expandLabel,
        colors = expandColors,
        onClick = onClick,
    )
}
