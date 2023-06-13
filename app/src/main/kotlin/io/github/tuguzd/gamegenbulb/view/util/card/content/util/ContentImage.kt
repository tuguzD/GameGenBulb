package io.github.tuguzd.gamegenbulb.view.util.card.content.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.image.TooltipImage

@Composable
fun ContentImage(
    contentImage: String?,
    modifier: Modifier = Modifier,
    errorIconSize: Dp = 64.dp,
    shape: Shape = RoundedCornerShape(12.dp),
    label: String = stringResource(R.string.image)
) = TooltipImage(
    modifier = modifier.clip(shape),
    imagePath = contentImage,
    label = label,
    error = {
        CardContentBox {
            Icon(
                modifier = Modifier.size(errorIconSize),
                imageVector = Icons.Rounded.NotInterested,
                contentDescription = null,
            )
        }
    },
)

@Composable
fun CardContentBox(
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.onSecondary,
    content: @Composable BoxScope.() -> Unit,
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .background(background),
    contentAlignment = Alignment.Center,
    content = content,
)
