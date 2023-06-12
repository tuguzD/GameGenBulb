package io.github.tuguzd.gamegenbulb.view.util.card.content.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineIconTitle
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun ContentHeader(
    contentName: String,
    votePercentage: Int?,
    expandedState: Boolean,
    expandNeeded: Boolean,
    onClick: () -> Unit,
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(12.dp),
) {
    OneLineTitle(
        modifier = Modifier.weight(1f),
        text = contentName,
        style = MaterialTheme.typography.titleLarge,
    )
    OneLineIconTitle(
        imageVector = Icons.Rounded.Star,
        label = votePercentage?.let { "$it%" } ?: "N/A",
    )
    if (expandNeeded) ExpandButton(
        expandedState = expandedState,
        onClick = onClick,
    )
}
