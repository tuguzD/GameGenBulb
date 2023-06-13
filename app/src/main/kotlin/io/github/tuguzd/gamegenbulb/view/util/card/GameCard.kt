package io.github.tuguzd.gamegenbulb.view.util.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category
import io.github.tuguzd.gamegenbulb.view.util.card.content.ContentCard
import io.github.tuguzd.gamegenbulb.view.util.card.content.Link
import kotlinx.serialization.Serializable

@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    game: Game,
    isFavourite: Boolean = false,
    categories: List<Category>? = null,
    onClick: () -> Unit = { },
) = ContentCard(
    modifier = modifier,
    contentName = game.name,
    contentImage = game.imagePath,
    links = game.links,
    categories = categories,
    canModify = false,
    devPubNeeded = true,
    isFavourite = isFavourite,
    developerName = game.developerName,
    publisherName = game.publisherName,
    rating = game.rating,
    onClick = onClick,
)

@Serializable
data class Game(
    val name: String,
    val imagePath: String? = null,
    val rating: Int? = null,
    val links: List<Link>? = null,
    val developerName: String? = null,
    val publisherName: String? = null,
)

data class GameCardContent(
    val game: Game,
    val categories: List<Category>,
    val favourite: Boolean,
)
