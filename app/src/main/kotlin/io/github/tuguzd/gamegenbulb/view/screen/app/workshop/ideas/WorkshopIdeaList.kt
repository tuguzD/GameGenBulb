package io.github.tuguzd.gamegenbulb.view.screen.app.workshop.ideas

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.ColorLens
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import io.github.tuguzd.gamegenbulb.view.screen.app.workshop.util.WorkshopNavGraph
import io.github.tuguzd.gamegenbulb.view.util.card.Idea
import io.github.tuguzd.gamegenbulb.view.util.card.IdeaCard
import io.github.tuguzd.gamegenbulb.view.util.card.IdeaCardContent
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category
import io.github.tuguzd.gamegenbulb.view.util.scaffold.AddFABScaffold

@WorkshopNavGraph(start = true)
@Destination
@Composable
fun WorkshopIdeaListScreen(
    modifier: Modifier = Modifier,
) = AddFABScaffold(
    onClick = { },
) {
    val padding = 16.dp
    val canModify = true

    val list = mutableListOf(
        IdeaCardContent(
            idea = Idea(
                name = "Mindʊni",
                creator = "Damir Tugushev",
                imagePath = "https://i.pinimg.com/736x/38/60/e9/" +
                        "3860e933a8e012db89060387b490d878.jpg",
                authors = null,
            ),
            categories = listOf(
                Category(
                    name = "Песочница",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "Приключение",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "Инди",
                    icon = Icons.Rounded.Person,
                ),
                Category(
                    name = "Воксель",
                    icon = Icons.Rounded.ColorLens,
                ),
            ),
            favourite = false,
        ),
    )

    LazyColumn(
        modifier = modifier.padding(horizontal = padding),
    ) {
        item { Spacer(modifier = Modifier.height(padding)) }
        items(list) {
            IdeaCard(
                idea = it.idea,
                canModify = canModify,
                categories = it.categories,
                isFavourite = it.favourite,
            )
            Spacer(modifier = Modifier.height(padding))
        }
    }
}
