package io.github.tuguzd.gamegenbulb.view.util

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MyIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit = { },
) = IconButton(
    modifier = modifier,
    onClick = onClick
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
    )
}
