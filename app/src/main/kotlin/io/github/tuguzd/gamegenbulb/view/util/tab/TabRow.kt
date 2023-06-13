package io.github.tuguzd.gamegenbulb.view.util.tab

import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TabRow(
    isScrollable: Boolean,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit,
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit = { },
) = if (!isScrollable) TabRow(
    modifier = modifier,
    indicator = indicator,
    selectedTabIndex = selectedTabIndex,
    tabs = tabs,
) else ScrollableTabRow(
    modifier = modifier,
    indicator = indicator,
    selectedTabIndex = selectedTabIndex,
    tabs = tabs,
)
