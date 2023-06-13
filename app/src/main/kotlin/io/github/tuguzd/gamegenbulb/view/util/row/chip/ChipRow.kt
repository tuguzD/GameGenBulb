package io.github.tuguzd.gamegenbulb.view.util.row.chip

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipRow(
    firstChipName: String,
    secondChipName: String,
    thirdChipName: String,
    rowSpace: Dp = 12.dp,
    scrollState: ScrollState = rememberScrollState(),
) = Row(
    modifier = Modifier
        .padding(vertical = 8.dp)
        .horizontalScroll(scrollState),
    horizontalArrangement = Arrangement.spacedBy(rowSpace),
) {
    Spacer(modifier = Modifier.width(rowSpace))

    FilterChip(
        selected = true,
        onClick = { },
        label = { OneLineTitle(text = firstChipName) },
    )
    FilterChip(
        selected = false,
        onClick = { },
        label = { OneLineTitle(text = secondChipName) },
    )
    FilterChip(
        selected = false,
        onClick = { },
        label = { OneLineTitle(text = thirdChipName) },
        trailingIcon = {
            Icon(
                contentDescription = thirdChipName,
                imageVector = Icons.Rounded.ArrowDropDown,
                tint = MaterialTheme.colorScheme.onSurface,
            )
        }
    )
    Spacer(modifier = Modifier.width(rowSpace))
}
