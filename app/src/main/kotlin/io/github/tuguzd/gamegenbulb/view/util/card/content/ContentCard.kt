package io.github.tuguzd.gamegenbulb.view.util.card.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Share
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.charlex.compose.RevealDirection
import de.charlex.compose.RevealSwipe
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.button.FavouriteIconButton
import io.github.tuguzd.gamegenbulb.view.util.button.TooltipIconButton
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.CharsChipRow
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.ContentImage
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.ExpandButton
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.IconTitleRow
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.LinkImageRow
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineIconTitle
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
fun ContentCard(
    modifier: Modifier = Modifier,
    contentName: String,
    contentImage: String? = null,
    links: List<Link>? = null,
    characteristics: List<Characteristic>? = null,
    canModify: Boolean,
    devPubNeeded: Boolean,
    developerName: String? = null,
    publisherName: String? = null,
    creatorName: String? = null,
    authors: List<String>? = null,
    votePercentage: Int? = null,
    onClick: () -> Unit = { },
) = RevealSwipe(
    maxRevealDp = 64.dp,
    closeOnBackgroundClick = false,
    shape = MaterialTheme.shapes.medium,
    backgroundCardEndColor = MaterialTheme.colorScheme.secondaryContainer,
    backgroundCardStartColor = MaterialTheme.colorScheme.secondaryContainer,
    hiddenContentStart = {
        HiddenContentColumn {
            var isFavourite by remember { mutableStateOf(false) }
            FavouriteIconButton(isFavourite) {
                isFavourite = !isFavourite
            }
            TooltipIconButton(
                imageVector = Icons.Rounded.Share,
                contentDescription = stringResource(R.string.share),
            )
        }
    },
    hiddenContentEnd = {
        if (canModify) HiddenContentColumn {
            TooltipIconButton(
                imageVector = Icons.Rounded.Edit,
                contentDescription = stringResource(R.string.edit),
            )
            TooltipIconButton(
                imageVector = Icons.Rounded.Delete,
                contentDescription = stringResource(R.string.delete),
            )
        }
    },
    directions = mutableSetOf(RevealDirection.StartToEnd).also {
        if (canModify) it.add(RevealDirection.EndToStart)
    }
) {
    ElevatedCard(
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
}

@Composable
private fun HiddenContentColumn(
    content: @Composable ColumnScope.() -> Unit,
) = Column(
    modifier = Modifier
        .fillMaxHeight()
        .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    content = content,
)

data class Link(
    val name: String,
    val imagePath: String,
)

data class Characteristic(
    val name: String,
    val icon: ImageVector,
)
