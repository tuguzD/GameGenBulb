package io.github.tuguzd.gamegenbulb.view.util.card.user

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import io.github.tuguzd.gamegenbulb.view.util.card.content.util.ContentImage
import io.github.tuguzd.gamegenbulb.view.util.card.user.util.ExpandColumn
import io.github.tuguzd.gamegenbulb.view.util.card.user.util.UserInfo
import io.github.tuguzd.gamegenbulb.view.util.card.util.CategoryChipRow

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun UserCard(
    user: UserData,
    isFavourite: Boolean,
    modifier: Modifier = Modifier,
    categories: List<Category>? = null,
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
    directions = mutableSetOf(RevealDirection.StartToEnd),
) {
    ElevatedCard(
        modifier = modifier,
        onClick = onClick,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            ContentImage(
                modifier = Modifier.size(120.dp),
                label = stringResource(R.string.user_avatar),
                contentImage = user.avatar,
            )
            UserInfo(
                user.name, user.displayName,
                user.email, user.phone,
            )
        }
        if (!categories.isNullOrEmpty())
            Surface(tonalElevation = 1.dp) {
                var expandedState by remember { mutableStateOf(false) }
                ExpandColumn(
                    expandedState = expandedState,
                    onClick = { expandedState = !expandedState },
                    text = stringResource(R.string.user_popular),
                ) {
                    CategoryChipRow(
                        categories = categories,
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp,
                        ),
                    )
                }
            }
    }
}

data class UserCardContent(
    val user: UserData,
    val categories: List<Category>?,
    val favourite: Boolean,
)
