package io.github.tuguzd.gamegenbulb.view.util.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.tuguzd.gamegenbulb.view.util.text.OneLineTitle
import io.github.tuguzd.gamegenbulb.view.util.button.NavigateUpIconButton

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
