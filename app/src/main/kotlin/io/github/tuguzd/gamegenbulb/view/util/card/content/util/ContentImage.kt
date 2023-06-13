package io.github.tuguzd.gamegenbulb.view.util.card.content.util

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.NotInterested
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.image.TooltipImage

@Composable
fun ContentImage(
    modifier: Modifier = Modifier,
    contentImage: String?
) = TooltipImage(
    modifier = modifier
        .height(180.dp)
        .clip(RoundedCornerShape(12.dp))
        .border(0.dp, Color.Transparent, RoundedCornerShape(12.dp)),
    imagePath = contentImage,
    label = stringResource(R.string.image),
    error = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onSecondary),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                modifier = Modifier.size(64.dp),
                imageVector = Icons.Rounded.NotInterested,
                contentDescription = null,
            )
        }
    },
)
