package io.github.tuguzd.gamegenbulb.view.util.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category
import io.github.tuguzd.gamegenbulb.view.util.card.content.ContentCard
import io.github.tuguzd.gamegenbulb.view.util.card.content.Link

@Composable
fun IdeaCard(
    modifier: Modifier = Modifier,
    idea: Idea,
    canModify: Boolean,
    links: List<Link>? = null,
    categories: List<Category>? = null,
    developerName: String? = null,
    publisherName: String? = null,
    votePercentage: Int? = null,
    onClick: () -> Unit = { },
) = ContentCard(
    modifier = modifier,
    contentName = idea.name,
    contentImage = idea.imagePath,
    creatorName = idea.creator,
    authors = idea.authors,
    links = links,
    categories = categories,
    canModify = canModify,
    devPubNeeded = false,
    developerName = developerName,
    publisherName = publisherName,
    votePercentage = votePercentage,
    onClick = onClick,
)

data class Idea(
    val name: String,
    val creator: String,
    val authors: List<String>?,
    val imagePath: String?,
)
