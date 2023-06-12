package io.github.tuguzd.gamegenbulb.view.util.card.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CategoryChipRow(
    categories: List<Category>?,
    modifier: Modifier = Modifier,
    chipModifier: Modifier = Modifier,
) = FlowRow(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
    categories?.forEach { char ->
        ElevatedFilterChip(
            modifier = chipModifier,
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = char.icon,
                    contentDescription = char.name,
                )
            },
            label = { Text(char.name) },
            selected = true,
            onClick = { },
        )
    }
}
