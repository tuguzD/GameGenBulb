@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.workshop.util

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Psychology
import androidx.compose.material.icons.rounded.TipsAndUpdates
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.destinations.SessionListScreenDestination
import io.github.tuguzd.gamegenbulb.view.screen.destinations.WorkshopIdeaListScreenDestination

enum class WorkshopDestination(
    val direction: DirectionDestinationSpec,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    Ideas(
        direction = WorkshopIdeaListScreenDestination,
        icon = Icons.Rounded.TipsAndUpdates,
        label = R.string.user_ideas,
    ),
    Sessions(
        direction = SessionListScreenDestination,
        icon = Icons.Rounded.Psychology,
        label = R.string.sessions,
    ),
}
