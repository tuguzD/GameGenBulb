package io.github.tuguzd.gamegenbulb.view.util

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec

interface UtilDestination {
    val direction: DirectionDestinationSpec
    val icon: ImageVector
    @get:StringRes val label: Int
}
