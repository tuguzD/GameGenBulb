package io.github.tuguzd.gamegenbulb.view.util.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.button.BadgeIconButton
import io.github.tuguzd.gamegenbulb.view.util.button.NavigateUpIconButton

@Composable
fun SearchResultTopBar(
    modifier: Modifier = Modifier,
    query: String? = null,
    navigator: DestinationsNavigator,
) = NavigateUpTopBar(
    modifier = modifier,
    title = query?.run { this }
        ?: stringResource(R.string.results),
    navigator = navigator,
    beforeNavigation = { navigator.navigateUp() }
) {
    NavigateUpIconButton(
        navigator = navigator,
        imageVector = Icons.Rounded.Search,
        contentDescription = stringResource(R.string.search),
    )
    BadgeIconButton(
        imageVector = Icons.Rounded.FilterList,
        contentDescription = stringResource(R.string.sorting),
    ) { }
    BadgeIconButton(
        imageVector = Icons.Rounded.Tune,
        contentDescription = stringResource(R.string.search_params),
    ) { }
}
