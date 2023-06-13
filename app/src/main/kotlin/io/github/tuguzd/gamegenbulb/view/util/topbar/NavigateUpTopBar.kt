package io.github.tuguzd.gamegenbulb.view.util.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.tuguzd.gamegenbulb.view.util.button.NavigateUpIconButton
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigateUpTopBar(
    modifier: Modifier = Modifier,
    title: String,
    navigator: DestinationsNavigator,
    beforeNavigation: () -> Unit = { },
    actions: @Composable RowScope.() -> Unit = { },
) = TopAppBar(
    modifier = modifier,
    title = {
        OneLineTitle(text = title)
    },
    navigationIcon = {
        NavigateUpIconButton(
            navigator = navigator,
            beforeNavigation = beforeNavigation,
        )
    },
    actions = actions,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigateUpLargeTopBar(
    modifier: Modifier = Modifier,
    title: String,
    navigator: DestinationsNavigator,
    beforeNavigation: () -> Unit = { },
    actions: @Composable RowScope.() -> Unit = { },
) = LargeTopAppBar(
    modifier = modifier,
    title = {
        OneLineTitle(text = title)
    },
    navigationIcon = {
        NavigateUpIconButton(
            navigator = navigator,
            beforeNavigation = beforeNavigation,
        )
    },
    actions = actions,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigateUpMediumTopBar(
    modifier: Modifier = Modifier,
    title: String,
    navigator: DestinationsNavigator,
    beforeNavigation: () -> Unit = { },
    actions: @Composable RowScope.() -> Unit = { },
) = MediumTopAppBar(
    modifier = modifier,
    title = {
        OneLineTitle(text = title)
    },
    navigationIcon = {
        NavigateUpIconButton(
            navigator = navigator,
            beforeNavigation = beforeNavigation,
        )
    },
    actions = actions,
)
