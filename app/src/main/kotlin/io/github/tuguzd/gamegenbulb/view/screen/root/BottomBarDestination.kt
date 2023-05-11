@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.root

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SdCard
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.destinations.CommunityScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.UserProfileScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.WorkshopScreenDestination

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    Community(
        direction = CommunityScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.community,
    ),
    Workshop(
        direction = WorkshopScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.workshop,
    ),
    UserProfile(
        direction = UserProfileScreenDestination,
        icon = Icons.Filled.SdCard,
        label = R.string.user_profile,
    ),
}
