package io.github.tuguzd.gamegenbulb.view.screen.app.community.ideas

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
import io.github.tuguzd.gamegenbulb.view.screen.app.community.util.CommunityNavGraph
import io.github.tuguzd.gamegenbulb.view.util.card.Idea
import io.github.tuguzd.gamegenbulb.view.util.card.IdeaCard
import io.github.tuguzd.gamegenbulb.view.util.card.IdeaCardContent
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category

@CommunityNavGraph(start = true)
@Destination
@Composable
fun CommunityIdeaListScreen(
    modifier: Modifier = Modifier,
) {
    val padding = 16.dp
    val canModify = false

    val list = mutableListOf(
        IdeaCardContent(
            idea = Idea(
                name = "Infernal Calamity",
                creator = "Steven Manzo",
                imagePath = "https://www.cuttingedgefirewood.com/wp-content/" +
                        "uploads/2021/11/fire-crack-1.jpg",
                authors = listOf(
                    "Irma K.", "Sigurdór G.",
                ),
                rating = 92,
            ),
            categories = listOf(
                Category(
                    name = "Симулятор",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "Пиксель",
                    icon = Icons.Rounded.ColorLens,
                ),
            ),
            favourite = false,
        ),
        IdeaCardContent(
            idea = Idea(
                name = "Tropical Beautician Racer",
                creator = "Isembold Brandagamba",
                imagePath = "https://img.freepik.com/premium-vector/" +
                        "old-style-pixel-game-palm-tropics-illustration_210544-25.jpg",
                authors = listOf("Beatriz C."),
            ),
            categories = listOf(
                Category(
                    name = "Платформер",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "Пиксель",
                    icon = Icons.Rounded.ColorLens,
                ),
            ),
            favourite = false,
        ),
        IdeaCardContent(
            idea = Idea(
                name = "Silent Goblin Panic",
                creator = "Joyce Fuston",
                imagePath = "https://cdna.artstation.com/p/assets/images/images/006/829/384/" +
                        "large/amelie-benard-gobelins-etonnes.jpg?1501573473",
                authors = listOf(
                    "Linda M.", "Tatiana K.", "Mikkel D.",
                ),
                rating = 82,
            ),
            categories = listOf(
                Category(
                    name = "Приключение",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "A-класс",
                    icon = Icons.Rounded.Person,
                ),
                Category(
                    name = "3D",
                    icon = Icons.Rounded.ColorLens,
                ),
            ),
            favourite = false,
        ),
        IdeaCardContent(
            idea = Idea(
                name = "Alterhunt",
                creator = "Sarah Ali",
                imagePath = "https://upload.wikimedia.org/wikipedia/commons/7/76/" +
                        "Dangerous_weapons_seized_from_holiday_flights_at_Manchester_Airport.jpg",
                authors = null,
                rating = 38,
            ),
            categories = listOf(
                Category(
                    name = "Аркада",
                    icon = Icons.Rounded.AutoStories,
                ),
                Category(
                    name = "Инди",
                    icon = Icons.Rounded.Person,
                ),
                Category(
                    name = "3D",
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
