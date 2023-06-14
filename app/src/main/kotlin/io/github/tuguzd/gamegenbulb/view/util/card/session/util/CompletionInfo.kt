package io.github.tuguzd.gamegenbulb.view.util.card.session.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChecklistRtl
import androidx.compose.material.icons.rounded.Rule
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
fun CompletionInfo(
    tasksCompleted: Boolean,
) = PlainTooltipBox(
    tooltip = {
        Text(
            if (tasksCompleted) "Все задачи выполнены!"
            else "Не все задачи выполнены"
        )
    },
) {
    CardContentBox(
        modifier = Modifier
            .tooltipAnchor()
            .size(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { },
    ) {
        Icon(
            modifier = Modifier.size(64.dp),
            imageVector = run {
                if (tasksCompleted) Icons.Rounded.ChecklistRtl
                else Icons.Rounded.Rule
            },
            tint = run {
                if (tasksCompleted) Color.Green else Color.Red
            }.copy(alpha = 0.75f),
            contentDescription = null,
        )
    }
}
