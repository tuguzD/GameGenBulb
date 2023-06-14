package io.github.tuguzd.gamegenbulb.view.util.card.user.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandCategoryRow(
    text: String,
    expandedState: Boolean,
    onClick: () -> Unit,
) {
    val label = stringResource(
        if (expandedState) R.string.expand
        else R.string.shrink
    )
    PlainTooltipBox(tooltip = { Text(label) }) {
        Row(
            modifier = Modifier
                .tooltipAnchor()
                .clickable { onClick() }
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            OneLineTitle(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp),
                text = text,
            )
            Icon(
                imageVector = run {
                    if (expandedState) Icons.Rounded.ExpandLess
                    else Icons.Rounded.ExpandMore
                },
                contentDescription = label,
            )
        }
    }
}
