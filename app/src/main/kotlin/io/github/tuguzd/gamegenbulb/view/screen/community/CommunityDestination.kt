@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.community

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SdCard
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.tuguzd.gamegenbulb.R

enum class CommunityDestination(
//    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    Authors(
//        direction = _ScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.authors,
    ),
    Ideas(
//        direction = _ScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.ideas,
    ),
    Games(
//        direction = _ScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.games,
    ),
}
