package io.github.tuguzd.gamegenbulb.view.util.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.view.util.MeasureUnconstrainedViewWidth
import io.github.tuguzd.gamegenbulb.view.util.UtilDestination

@Composable
fun <D : UtilDestination> TabRowIndicator(
    isPrimary: Boolean,
    destination: D,
    tabPosition: TabPosition,
) = if (isPrimary) MeasureUnconstrainedViewWidth(
    viewToMeasure = {
        Text(
            text = stringResource(destination.label),
            style = MaterialTheme.typography.titleSmall,
        )
    },
) {
    PrimaryIndicator(
        modifier = Modifier.tabIndicatorOffset(tabPosition),
        padding = (tabPosition.width - it) / 2,
    )
} else {
    TabRowDefaults.Indicator(
        modifier = Modifier.tabIndicatorOffset(tabPosition),
    )
}

@Composable
fun PrimaryIndicator(
    padding: Dp,
    modifier: Modifier = Modifier,
    height: Dp = 3.dp,
    color: Color = MaterialTheme.colorScheme.primary,
) = Box(
    modifier = modifier
        .padding(horizontal = padding)
        .height(height)
        .clip(RoundedCornerShape(topStart = height, topEnd = height))
        .background(color)
)
