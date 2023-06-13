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
    links: List<Link>? = null,
    categories: List<Category>? = null,
    developerName: String? = null,
    publisherName: String? = null,
    votePercentage: Int? = null,
    onClick: () -> Unit = { },
) = ContentCard(
    modifier = modifier,
    contentName = game.name,
    contentImage = game.imagePath,
    links = links,
    categories = categories,
    canModify = false,
    devPubNeeded = true,
    developerName = developerName,
    publisherName = publisherName,
    votePercentage = votePercentage,
    onClick = onClick,
)

@Serializable
data class Game(
    val name: String,
    val imagePath: String?,
)
