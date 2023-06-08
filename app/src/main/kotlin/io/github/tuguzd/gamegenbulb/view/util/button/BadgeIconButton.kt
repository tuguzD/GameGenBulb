package io.github.tuguzd.gamegenbulb.view.util.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeIconButton(
    modifier: Modifier = Modifier,
    text: Int? = null,
    needBadge: Boolean = false,
    imageVector: ImageVector,
    contentDescription: String,
    onClick: () -> Unit = { },
) = TooltipIconButtonC(
    modifier = modifier,
    imageVector = imageVector,
    contentDescription = contentDescription,
    onClick = onClick,
) {
    if (needBadge) {
        BadgedBox(
            badge = {
                text?.also {
                    Badge { Text(it.toString()) }
                } ?: Badge()
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(16.dp)
                    .alpha(0f),
                imageVector = imageVector,
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun TooltipIconButtonC(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = { },
    content: @Composable () -> Unit = { },
) = TooltipIconButton(
    modifier = modifier,
    imageVector = imageVector,
    contentDescription = contentDescription,
    enabled = enabled,
    colors = colors,
    interactionSource = interactionSource,
    content = content,
    onClick = onClick,
)
