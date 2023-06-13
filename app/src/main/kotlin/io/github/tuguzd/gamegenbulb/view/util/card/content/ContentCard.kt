package io.github.tuguzd.gamegenbulb.view.util.card.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.HiddenContentColumn
import io.github.tuguzd.gamegenbulb.view.util.RevealSwipe
import io.github.tuguzd.gamegenbulb.view.util.button.FavouriteIconButton
import io.github.tuguzd.gamegenbulb.view.util.button.TooltipIconButton
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.ContentHeader
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.ContentImage
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.IconTitleRow
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.LinkImageRow
import io.github.tuguzd.gamegenbulb.view.util.card.util.CategoryChipRow
import kotlinx.serialization.Serializable

@Composable
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
fun ContentCard(
    modifier: Modifier = Modifier,
    contentName: String,
    canModify: Boolean,
    isFavourite: Boolean,
    devPubNeeded: Boolean,
    contentImage: String? = null,
    links: List<Link>? = null,
    categories: List<Category>? = null,
    developerName: String? = null,
    publisherName: String? = null,
    creatorName: String? = null,
    authors: List<String>? = null,
    rating: Int? = null,
    onClick: () -> Unit = { },
) = RevealSwipe(
    hiddenContentStart = {
        HiddenContentColumn {
            var favouriteState by remember { mutableStateOf(isFavourite) }
            FavouriteIconButton(favouriteState) {
                favouriteState = !favouriteState
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

        AnimatedVisibility(
            visible = expandedState && links != null,
            enter = expandVertically(expandFrom = Alignment.Bottom),
            exit = shrinkVertically(shrinkTowards = Alignment.Bottom),
        ) {
            LinkImageRow(links)
        }
        ContentImage(
            modifier = Modifier.height(180.dp),
            contentImage = contentImage,
        )

        Column(
            modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                ContentHeader(
                    contentName = contentName,
                    votePercentage = rating,
                    expandNeeded = (links != null || categories != null),
                    expandedState = expandedState,
                    onClick = { expandedState = !expandedState }
                )
                IconTitleRow(
                    devPubNeeded, developerName,
                    publisherName, creatorName, authors,
                )
            }
            AnimatedVisibility(
                visible = (expandedState && categories != null),
                enter = expandVertically(expandFrom = Alignment.Top),
                exit = shrinkVertically(shrinkTowards = Alignment.Top),
            ) {
                CategoryChipRow(categories)
            }
        }
    }
}

@Serializable
data class Link(
    val name: String,
    val imagePath: String,
)

data class Category(
    val name: String,
    val icon: ImageVector,
)
