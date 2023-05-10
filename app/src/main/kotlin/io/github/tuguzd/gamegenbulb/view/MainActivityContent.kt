package io.github.tuguzd.gamegenbulb.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SdCard
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.DestinationsNavHost
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.basic.BasicTopBar
import io.github.tuguzd.gamegenbulb.view.theme.AppTheme

@Composable
fun MainActivityContent() {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Temp()
        }
    }
}

@Composable
fun Temp() {
    var state by remember { mutableStateOf(0) }
    val list = listOf(
        stringResource(R.string.community),
        stringResource(R.string.workshop),
        stringResource(R.string.user_profile),
    )
    Scaffold(
        topBar = { BasicTopBar() },
        bottomBar = {
            NavigationBar {
                list.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = state == index,
                        onClick = { state = index },
                        label = { Text(item) },
                        icon = { Icon(Icons.Filled.SdCard, contentDescription = item) },
                    )
                }
            }
        },
    ) { padding ->
        DestinationsNavHost(
            navGraph = NavGraphs.root,
            modifier = Modifier.padding(padding),
        )
    }
}
