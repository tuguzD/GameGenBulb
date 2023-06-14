package io.github.tuguzd.gamegenbulb.view.util.card.session.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Highlight
import androidx.compose.material.icons.rounded.Lightbulb
import androidx.compose.material.icons.rounded.Timelapse
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineIconTitle
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
fun SessionInfo(
    mainTaskName: String,
    methodName: String,
    ideaCount: String?,
    duration: String,
) = Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp),
) {
    OneLineTitle(
        style = MaterialTheme.typography.titleLarge,
        text = mainTaskName,
    )
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        OneLineIconTitle(
            imageVector = Icons.Rounded.Highlight,
            label = methodName,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            OneLineIconTitle(
                modifier = Modifier.weight(1f),
                imageVector = Icons.Rounded.Timelapse,
                label = duration,
            )
            ideaCount?.let {
                OneLineIconTitle(
                    imageVector = Icons.Rounded.Lightbulb,
                    label = it,
                )
            }
        }
    }
}
