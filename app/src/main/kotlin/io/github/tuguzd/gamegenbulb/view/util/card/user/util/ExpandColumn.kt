package io.github.tuguzd.gamegenbulb.view.util.card.user.util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun ExpandColumn(
    expandedState: Boolean,
    onClick: () -> Unit,
    text: String,
    hiddenContent: @Composable AnimatedVisibilityScope.() -> Unit,
) = Column {
    ExpandCategoryRow(
        text = text,
        expandedState = expandedState,
        onClick = onClick,
    )
    AnimatedVisibility(
        visible = expandedState,
        enter = expandVertically(expandFrom = Alignment.Top),
        exit = shrinkVertically(shrinkTowards = Alignment.Top),
        content = hiddenContent,
    )
}
