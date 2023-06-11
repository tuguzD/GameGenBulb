package io.github.tuguzd.gamegenbulb.view.util.card.content.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Publish
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun PubDevTitle(
    modifier: Modifier = Modifier,
    label: String,
    iconSize: Dp = 18.dp,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) = Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp),
) {
    val tint =
        if (label != stringResource(R.string.no_data))
            LocalContentColor.current
        else MaterialTheme.colorScheme.error

    Icon(
        modifier = Modifier.size(iconSize),
        imageVector = Icons.Rounded.Code,
        contentDescription = label,
        tint = tint,
    )
    Icon(
        modifier = Modifier.size(iconSize),
        imageVector = Icons.Rounded.Publish,
        contentDescription = label,
        tint = tint,
    )
    OneLineTitle(
        text = label,
        style = textStyle,
    )
}
