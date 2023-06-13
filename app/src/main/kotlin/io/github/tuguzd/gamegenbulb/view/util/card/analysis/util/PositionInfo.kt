package io.github.tuguzd.gamegenbulb.view.util.card.analysis.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.CardContentBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PositionInfo(
    position: Int,
    listSize: Int,
) = PlainTooltipBox(
    tooltip = { Text("$position / $listSize") },
) {
    CardContentBox(
        modifier = Modifier
            .tooltipAnchor()
            .size(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { },
    ) {
        val color = when (position.toFloat() / listSize.toFloat()) {
            in 0.0f..0.33f -> Color.Green
            in 0.34f..0.66f -> Color.Yellow
            in 0.67f..1.0f -> Color.Red
            else -> Color.Blue
        }
        Text(
            text = position.toString(),
            color = color.copy(alpha = 0.75f),
            style = MaterialTheme.typography.displayLarge,
        )
    }
}
