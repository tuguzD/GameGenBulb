package io.github.tuguzd.gamegenbulb.view.util.card.user

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.charlex.compose.RevealDirection
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserData
import io.github.tuguzd.gamegenbulb.view.util.HiddenContentColumn
import io.github.tuguzd.gamegenbulb.view.util.RevealSwipe
import io.github.tuguzd.gamegenbulb.view.util.button.FavouriteIconButton
import io.github.tuguzd.gamegenbulb.view.util.button.TooltipIconButton
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category
import io.github.tuguzd.gamegenbulb.view.util.card.user.util.ExpandColumn
import io.github.tuguzd.gamegenbulb.view.util.card.user.util.UserInfo
import io.github.tuguzd.gamegenbulb.view.util.image.TooltipImage

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun UserCard(
    user: UserData,
    modifier: Modifier = Modifier,
    categories: List<Category>? = null,
    onClick: () -> Unit = { },
) = RevealSwipe(
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
    directions = mutableSetOf(RevealDirection.StartToEnd),
) {
    ElevatedCard(
        modifier = modifier,
        onClick = onClick,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            val shape = RoundedCornerShape(12.dp)
            TooltipImage(
                modifier = Modifier
                    .size(120.dp)
                    .clip(shape)
                    .border(0.dp, Color.Transparent, shape),
                label = stringResource(R.string.user_avatar),
                imagePath = user.avatar,
            )
            UserInfo(
                user.name, user.displayName,
                user.email, user.phone,
            )
        }
        categories?.let {
            Surface(tonalElevation = 1.dp) {
                var expandedState by remember { mutableStateOf(false) }
                ExpandColumn(
                    categories = it,
                    expandedState = expandedState,
                    onClick = { expandedState = !expandedState }
                )
            }
        }
    }
}
