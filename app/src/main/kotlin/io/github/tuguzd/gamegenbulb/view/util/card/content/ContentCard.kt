package io.github.tuguzd.gamegenbulb.view.util.card.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.*
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineIconTitle
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ContentCard(
    modifier: Modifier = Modifier,
    contentName: String,
    contentImage: String? = null,
    links: List<Link>? = null,
    characteristics: List<Characteristic>? = null,
    devPubNeeded: Boolean,
    developerName: String? = null,
    publisherName: String? = null,
    creatorName: String? = null,
    authors: List<String>? = null,
    votePercentage: Int? = null,
    onClick: () -> Unit = { },
) = ElevatedCard(
    modifier = modifier,
    onClick = onClick,
) {
    var expandedState by remember { mutableStateOf(false) }

    if (expandedState && links != null)
        LinkImageRow(links)
    ContentImage(contentImage = contentImage)

    Column(
        modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                OneLineTitle(
                    text = contentName,
                    style = MaterialTheme.typography.titleLarge,
                )
                OneLineIconTitle(
                    imageVector = Icons.Rounded.Star,
                    label = votePercentage?.let { "$it%" } ?: "N/A",
                )
                Spacer(Modifier.weight(1f))

                if (links != null || characteristics != null)
                    ExpandButton(expandedState) {
                        expandedState = !expandedState
                    }
            }
            IconTitleRow(
                devPubNeeded, developerName,
                publisherName, creatorName, authors,
            )
        }
        if (expandedState && characteristics != null)
            CharsChipRow(characteristics)
    }
}

data class Link(
    val name: String,
    val imagePath: String,
)

data class Characteristic(
    val name: String,
    val icon: ImageVector,
)
