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
) = TooltipIconButton(
    imageVector = run {
        if (!expandedState) Icons.Rounded.Fullscreen
        else Icons.Rounded.FullscreenExit
    },
    contentDescription = stringResource(
        if (!expandedState) R.string.expand
        else R.string.shrink
    ),
    colors = run {
        if (!expandedState) IconButtonDefaults.iconButtonColors()
        else IconButtonDefaults.filledTonalIconButtonColors()
    },
    onClick = onClick,
)
