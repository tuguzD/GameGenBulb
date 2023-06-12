package io.github.tuguzd.gamegenbulb.view.screen.app.community.ideas

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.ColorLens
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import io.github.tuguzd.gamegenbulb.view.screen.app.community.util.CommunityNavGraph
import io.github.tuguzd.gamegenbulb.view.util.card.Idea
import io.github.tuguzd.gamegenbulb.view.util.card.IdeaCard
import io.github.tuguzd.gamegenbulb.view.util.card.content.Characteristic

@CommunityNavGraph(start = true)
@Destination
@Composable
fun CommunityIdeaListScreen(
    modifier: Modifier = Modifier,
) {
    val padding = 16.dp

    LazyColumn(
        modifier = modifier.padding(horizontal = padding),
    ) {
        item { Spacer(modifier = Modifier.height(padding)) }
        item {
            IdeaCard(
                idea = Idea(
                    name = "Infernal Calamity",
                    creator = "Steven Manzo",
                    imagePath = "https://www.cuttingedgefirewood.com/wp-content/" +
                            "uploads/2021/11/fire-crack-1.jpg",
                    authors = listOf(
                        "Irma K.", "Sigurdór G.",
                    ),
                ),
                canModify = true,
                characteristics = listOf(
                    Characteristic(
                        name = "Симулятор",
                        icon = Icons.Rounded.AutoStories,
                    ),
                    Characteristic(
                        name = "3D",
                        icon = Icons.Rounded.ColorLens,
                    ),
                ),
            )
            Spacer(modifier = Modifier.height(padding))
        }
    }
}
