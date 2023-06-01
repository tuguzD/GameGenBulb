package io.github.tuguzd.gamegenbulb.view.util

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    contentDescription: String?,
    onClick: () -> Unit,
) = IconButton(
    modifier = modifier,
    onClick = onClick,
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
    )
    if (needBadge) {
        BadgedBox(
            badge = {
                text?.also {
                    Badge { Text(text.toString()) }
                } ?: Badge()
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(18.dp)
                    .alpha(0f),
                imageVector = imageVector,
                contentDescription = null,
            )
        }
    }
}
