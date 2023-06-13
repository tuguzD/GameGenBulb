package io.github.tuguzd.gamegenbulb.view.screen.app.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate
import io.github.tuguzd.gamegenbulb.view.screen.NavGraph
import io.github.tuguzd.gamegenbulb.view.screen.appCurrentDestinationAsState
import io.github.tuguzd.gamegenbulb.view.screen.destinations.Destination
import io.github.tuguzd.gamegenbulb.view.screen.startAppDestination
import io.github.tuguzd.gamegenbulb.view.util.UtilDestination

@Composable
fun <D : UtilDestination> AppTabRow(
    navGraph: NavGraph,
    navController: NavController,
    isPrimary: Boolean,
    destinations: Array<D>,
    modifier: Modifier = Modifier,
) {
    val currentDestination: Destination =
        navController.appCurrentDestinationAsState().value
            ?: navGraph.startAppDestination

    val index = destinations.indexOfFirst {
        it.direction == currentDestination
    }
    var state by remember(index) { mutableStateOf(index) }

    TabRow(
        modifier = modifier,
        selectedTabIndex = state,
    ) {
        destinations.forEachIndexed { index, destination ->
            AppIconTab(
                isPrimary = isPrimary,
                destination = destination,
                selected = state == index,
            ) {
                state = index
                navController.navigate(destination.direction) {
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }
}

@Composable
fun <D : UtilDestination> AppScrollableTabRow(
    navGraph: NavGraph,
    navController: NavController,
    isPrimary: Boolean,
    destinations: Array<D>,
    modifier: Modifier = Modifier,
) {
    val currentDestination: Destination =
        navController.appCurrentDestinationAsState().value
            ?: navGraph.startAppDestination

    val index = destinations.indexOfFirst {
        it.direction == currentDestination
    }
    var state by remember(index) { mutableStateOf(index) }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        if (isPrimary) MeasureUnconstrainedViewWidth(
            viewToMeasure = {
                Text(
                    text = stringResource(destinations[state].label),
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        ) {
            PrimaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[state]),
                padding = (tabPositions[state].width - it) / 2,
            )
        }
        else {
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[state])
            )
        }
    }

    ScrollableTabRow(
        modifier = modifier,
        selectedTabIndex = state,
        indicator = indicator,
    ) {
        destinations.forEachIndexed { index, destination ->
            AppIconTab(
                isPrimary = isPrimary,
                destination = destination,
                selected = state == index,
            ) {
                state = index
                navController.navigate(destination.direction) {
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }
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

@Composable
fun MeasureUnconstrainedViewWidth(
    viewToMeasure: @Composable () -> Unit,
    content: @Composable (measuredWidth: Dp) -> Unit,
) {
    SubcomposeLayout { constraints ->
        val measuredWidth = subcompose("viewToMeasure", viewToMeasure)[0]
            .measure(Constraints()).width.toDp()

        val contentPlaceable = subcompose("content") {
            content(measuredWidth)
        }[0].measure(constraints)

        layout(contentPlaceable.width, contentPlaceable.height) {
            contentPlaceable.place(0, 0)
        }
    }
}
