@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.community

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SdCard
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.destinations.AuthorListScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.GameListScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.IdeaListScreenDestination

enum class CommunityDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    Authors(
        direction = AuthorListScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.authors,
    ),
    Ideas(
        direction = IdeaListScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.ideas,
    ),
    Games(
        direction = GameListScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.games,
    ),
}
