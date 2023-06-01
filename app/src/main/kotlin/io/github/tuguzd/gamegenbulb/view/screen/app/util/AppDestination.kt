@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.app.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Handyman
import androidx.compose.material.icons.rounded.Public
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.destinations.CommunityScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.ProfileScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.WorkshopScreenDestination

enum class AppDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    Community(
        direction = CommunityScreenDestination,
        icon = Icons.Rounded.Public,
        label = R.string.community,
    ),
    Workshop(
        direction = WorkshopScreenDestination,
        icon = Icons.Rounded.Handyman,
        label = R.string.workshop,
    ),
    Profile(
        direction = ProfileScreenDestination,
        icon = Icons.Rounded.AccountCircle,
        label = R.string.user_profile,
    ),
}
