package io.github.tuguzd.gamegenbulb.view.util.card.analysis.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Label
import androidx.compose.material.icons.rounded.Lightbulb
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.SportsEsports
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineIconTitle

@Composable
fun AnalysisInfo(
    ideaName: String,
    criterion: String,
    listType: String,
    timePassed: String,
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
) {
    OneLineIconTitle(
        label = ideaName,
        iconSize = 24.dp,
        imageVector = Icons.Rounded.Lightbulb,
        textStyle = MaterialTheme.typography.titleLarge,
    )
    Column(
        modifier = Modifier.padding(start = 2.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            OneLineIconTitle(
                modifier = Modifier.weight(1f),
                imageVector = Icons.Rounded.Label,
                label = criterion,
            )
            OneLineIconTitle(
                imageVector = run {
                    if (listType == "Игры") Icons.Rounded.SportsEsports
                    else Icons.Rounded.Lightbulb
                },
                label = listType,
            )
        }
        OneLineIconTitle(
            imageVector = Icons.Rounded.Schedule,
            label = timePassed,
        )
    }
}
