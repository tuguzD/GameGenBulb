package io.github.tuguzd.gamegenbulb.view.util.card.user.util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category
import io.github.tuguzd.gamegenbulb.view.util.card.util.CategoryChipRow

@Composable
fun ExpandColumn(
    expandedState: Boolean,
    categories: List<Category>?,
    onClick: () -> Unit,
) = Column {
    ExpandCategoryRow(
        expandedState = expandedState,
        onClick = onClick,
    )
    AnimatedVisibility(
        visible = expandedState,
        enter = expandVertically(expandFrom = Alignment.Top),
        exit = shrinkVertically(shrinkTowards = Alignment.Top),
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
