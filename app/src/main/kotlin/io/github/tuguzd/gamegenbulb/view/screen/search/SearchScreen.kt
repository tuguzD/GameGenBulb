package io.github.tuguzd.gamegenbulb.view.screen.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.destinations.SearchResultScreenDestination
import io.github.tuguzd.gamegenbulb.view.util.NavigateUpIconButton
import io.github.tuguzd.gamegenbulb.view.util.TooltipIconButton

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph
@Destination
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
) {
    var text by remember { mutableStateOf("") }

    SearchBar(
        modifier = modifier
            .fillMaxSize()
            .offset(y = (-4).dp),
        query = text,
        onQueryChange = { text = it },
        onSearch = {
            navigator.navigate(SearchResultScreenDestination)
        },
        active = true,
        onActiveChange = {
            if (!it) navigator.navigateUp()
        },
        placeholder = {
            Text(stringResource(R.string.search))
        },
        leadingIcon = {
            NavigateUpIconButton(navigator = navigator)
        },
        trailingIcon = {
            if (text.isNotBlank()) {
                TooltipIconButton(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = stringResource(R.string.clear),
                ) { text = "" }
            }
        }
    ) { }
}
