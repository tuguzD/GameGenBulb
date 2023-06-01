@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.community.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.People
import androidx.compose.material.icons.rounded.SportsEsports
import androidx.compose.material.icons.rounded.TipsAndUpdates
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
        icon = Icons.Rounded.People,
        label = R.string.authors,
    ),
    Ideas(
        direction = IdeaListScreenDestination,
        icon = Icons.Rounded.TipsAndUpdates,
        label = R.string.ideas,
    ),
    Games(
        direction = GameListScreenDestination,
        icon = Icons.Rounded.SportsEsports,
        label = R.string.games,
    ),
}
