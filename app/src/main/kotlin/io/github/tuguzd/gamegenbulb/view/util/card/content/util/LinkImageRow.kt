package io.github.tuguzd.gamegenbulb.view.util.card.content.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.card.content.Link
import io.github.tuguzd.gamegenbulb.view.util.image.TooltipImage

@Composable
fun LinkImageRow(
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
