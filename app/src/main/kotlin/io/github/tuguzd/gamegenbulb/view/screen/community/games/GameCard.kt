package io.github.tuguzd.gamegenbulb.view.screen.community.games

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.tuguzd.gamegenbulb.view.util.card.Characteristic
import io.github.tuguzd.gamegenbulb.view.util.card.ContentCard
import io.github.tuguzd.gamegenbulb.view.util.card.Link

@Composable
fun GameCard(
    modifier: Modifier = Modifier,
    game: Game,
    links: List<Link>? = null,
    characteristics: List<Characteristic>? = null,
    developerName: String? = null,
    publisherName: String? = null,
    votePercentage: Int? = null,
    onClick: () -> Unit = { },
) = ContentCard(
    modifier = modifier,
    contentName = game.name,
    contentImage = game.imagePath,
    links = links,
    characteristics = characteristics,
    devPubNeeded = true,
    developerName = developerName,
    publisherName = publisherName,
    votePercentage = votePercentage,
    onClick = onClick,
)

data class Game(
    val name: String,
    val imagePath: String?,
)
