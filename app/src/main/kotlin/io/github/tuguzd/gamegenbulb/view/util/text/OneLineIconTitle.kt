package io.github.tuguzd.gamegenbulb.view.util.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OneLineIconTitle(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    label: String,
    iconSize: Dp = 18.dp,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) = Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp),
) {
    Icon(
        modifier = Modifier.size(iconSize),
        imageVector = imageVector,
        contentDescription = label,
    )
    OneLineTitle(
        text = label,
        style = textStyle,
    )
}
