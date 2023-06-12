package io.github.tuguzd.gamegenbulb.view.screen.app.workshop.ideas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.annotation.Destination
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.app.workshop.util.WorkshopNavGraph
import io.github.tuguzd.gamegenbulb.view.util.scaffold.AddFABScaffold

@WorkshopNavGraph(start = true)
@Destination
@Composable
fun WorkshopIdeaListScreen(
    modifier: Modifier = Modifier,
) = AddFABScaffold(
    onClick = { },
) { padding ->
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.user_ideas))
    }
}
