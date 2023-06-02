package io.github.tuguzd.gamegenbulb.view.util

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit = { },
    onClick: () -> Unit = { },
) = PlainTooltipBox(
    tooltip = { Text(contentDescription) }
) {
    IconButton(
        modifier = modifier.tooltipAnchor(),
        imageVector = imageVector,
        contentDescription = contentDescription,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource,
        content = content,
        onClick = onClick,
    )
}

@Composable
private fun IconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String?,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit = { },
    onClick: () -> Unit = { },
) = IconButton(
    modifier = modifier,
    enabled = enabled,
    colors = colors,
    interactionSource = interactionSource,
    onClick = onClick,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
    )
    content()
}
