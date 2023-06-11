package io.github.tuguzd.gamegenbulb.view.util.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Fullscreen
import androidx.compose.material.icons.rounded.FullscreenExit
import androidx.compose.material.icons.rounded.NotInterested
import androidx.compose.material.icons.rounded.Publish
import androidx.compose.material.icons.rounded.RecordVoiceOver
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.button.TooltipIconButton
import io.github.tuguzd.gamegenbulb.view.util.image.TooltipImage
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
    authorName: String? = null,
    votePercentage: Int? = null,
    onClick: () -> Unit = { },
) = ElevatedCard(
    modifier = modifier,
    onClick = onClick,
) {
    val defName = stringResource(R.string.no_data)
    val devName = developerName ?: publisherName ?: defName
    val pubName = publisherName ?: developerName ?: defName

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

                if (links != null && characteristics != null)
                    ExpandButton(expandedState) {
                        expandedState = !expandedState
                    }
            }

            if (devName != defName && pubName != defName || devPubNeeded) {
                if (devPubNeeded && devName == pubName)
                    PubDevTitle(label = devName)
                else Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    OneLineIconTitle(
                        imageVector = Icons.Rounded.Code,
                        label = devName,
                    )
                    OneLineIconTitle(
                        imageVector = Icons.Rounded.Publish,
                        label = pubName,
                    )
                }
            }

            authorName?.let {
                OneLineIconTitle(
                    imageVector = Icons.Rounded.RecordVoiceOver,
                    label = authorName,
                )
            }
        }
        if (expandedState && characteristics != null)
            CharsChipRow(characteristics)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
private fun CharsChipRow(
    characteristics: List<Characteristic>?,
) = FlowRow(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
    characteristics?.forEach { char ->
        ElevatedFilterChip(
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

@Composable
private fun LinkImageRow(
    links: List<Link>?,
) = Row(
    modifier = Modifier.padding(16.dp, 12.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
    links?.forEach { link ->
        TooltipImage(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            imagePath = link.imagePath,
            label = link.name,
        )
    }
}

@Composable
private fun ContentImage(contentImage: String?) {
    val gameImageModifier = Modifier
        .height(180.dp)
        .clip(RoundedCornerShape(12.dp))
        .border(0.dp, Color.Transparent, RoundedCornerShape(12.dp))

    contentImage?.let {
        TooltipImage(
            modifier = gameImageModifier,
            imagePath = it,
            label = stringResource(R.string.image),
        )
    } ?: Column(
        modifier = gameImageModifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSecondary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            modifier = Modifier.size(64.dp),
            imageVector = Icons.Rounded.NotInterested,
            contentDescription = null,
        )
    }
}

@Composable
private fun ExpandButton(
    expandedState: Boolean,
    onClick: () -> Unit,
) {
    val expandIcon =
        if (!expandedState) Icons.Rounded.Fullscreen
        else Icons.Rounded.FullscreenExit
    val expandLabel = stringResource(
        if (expandedState) R.string.shrink
        else R.string.expand
    )
    val expandColors =
        if (!expandedState) IconButtonDefaults.iconButtonColors()
        else IconButtonDefaults.filledTonalIconButtonColors()

    TooltipIconButton(
        imageVector = expandIcon,
        contentDescription = expandLabel,
        colors = expandColors,
        onClick = onClick,
    )
}

@Composable
private fun PubDevTitle(
    modifier: Modifier = Modifier,
    label: String,
    iconSize: Dp = 18.dp,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) = Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(4.dp),
) {
    val tint =
        if (label != stringResource(R.string.no_data))
            LocalContentColor.current
        else MaterialTheme.colorScheme.error

    Icon(
        modifier = Modifier.size(iconSize),
        imageVector = Icons.Rounded.Code,
        contentDescription = label,
        tint = tint,
    )
    Icon(
        modifier = Modifier.size(iconSize),
        imageVector = Icons.Rounded.Publish,
        contentDescription = label,
        tint = tint,
    )
    OneLineTitle(
        text = label,
        style = textStyle,
    )
}

data class Link(
    val name: String,
    val imagePath: String,
)

data class Characteristic(
    val name: String,
    val icon: ImageVector,
)
