package io.github.tuguzd.gamegenbulb.view.screen.game.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Campaign
import androidx.compose.material.icons.rounded.CopyAll
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.HotelClass
import androidx.compose.material.icons.rounded.Shop
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.destinations.GameDescriptionScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.GameRatingScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.GameSimilarScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.GameSocialScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.GameStoreListScreenDestination
import io.github.tuguzd.gamegenbulb.view.util.UtilDestination

enum class GameDestination(
    override val direction: DirectionDestinationSpec,
    override val icon: ImageVector,
    @StringRes override val label: Int,
) : UtilDestination {
    Description(
        direction = GameDescriptionScreenDestination,
        icon = Icons.Rounded.Description,
        label = R.string.description,
    ),
    Rating(
        direction = GameRatingScreenDestination,
        icon = Icons.Rounded.HotelClass,
        label = R.string.rating,
    ),
    Similar(
        direction = GameSimilarScreenDestination,
        icon = Icons.Rounded.CopyAll,
        label = R.string.similar,
    ),
    SocialMedia(
        direction = GameSocialScreenDestination,
        icon = Icons.Rounded.Campaign,
        label = R.string.social_media,
    ),
    Store(
        direction = GameStoreListScreenDestination,
        icon = Icons.Rounded.Shop,
        label = R.string.store_list,
    ),
}
