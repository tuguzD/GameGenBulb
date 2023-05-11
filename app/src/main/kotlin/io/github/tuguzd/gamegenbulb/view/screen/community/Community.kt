package io.github.tuguzd.gamegenbulb.view.screen.community

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SdCard
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import io.github.tuguzd.gamegenbulb.R

@RootNavGraph(start = true)
@Destination
@Composable
fun CommunityScreen() {
    var state by remember { mutableStateOf(0) }
    val list = listOf(
        stringResource(R.string.authors),
        stringResource(R.string.ideas),
        stringResource(R.string.games),
    )
    Column {
        TabRow(selectedTabIndex = state) {
            list.forEachIndexed { index, item ->
                LeadingIconTab(
                    selected = state == index,
                    onClick = { state = index },
                    text = { Text(text = item) },
                    icon = { Icon(Icons.Filled.SdCard, contentDescription = item) },
                )
            }
        }
        Text(text = "${stringResource(R.string.community)} — ${list[state]}")
    }
}
