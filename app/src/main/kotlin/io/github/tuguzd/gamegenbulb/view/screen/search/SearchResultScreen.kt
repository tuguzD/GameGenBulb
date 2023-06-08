package io.github.tuguzd.gamegenbulb.view.screen.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.topbar.SearchResultTopBar

@RootNavGraph
@Destination
@Composable
fun SearchResultScreen(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
) {
    val label = stringResource(R.string.results)
    Scaffold(
        modifier = modifier,
        topBar = {
            SearchResultTopBar(
                query = label,
                navigator = navigator,
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label)
        }
    }
}
