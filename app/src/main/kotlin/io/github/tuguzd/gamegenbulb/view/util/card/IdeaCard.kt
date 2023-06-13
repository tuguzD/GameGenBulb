package io.github.tuguzd.gamegenbulb.view.util.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.tuguzd.gamegenbulb.view.util.card.content.Category
import io.github.tuguzd.gamegenbulb.view.util.card.content.ContentCard
import io.github.tuguzd.gamegenbulb.view.util.card.content.Link
import kotlinx.serialization.Serializable

@Composable
fun IdeaCard(
    modifier: Modifier = Modifier,
    idea: Idea,
    canModify: Boolean,
    isFavourite: Boolean,
    categories: List<Category>? = null,
    onClick: () -> Unit = { },
) = ContentCard(
    modifier = modifier,
    contentName = idea.name,
    contentImage = idea.imagePath,
    creatorName = idea.creator,
    authors = idea.authors,
    links = idea.links,
    categories = categories,
    canModify = canModify,
    isFavourite = isFavourite,
    devPubNeeded = false,
    developerName = idea.developerName,
    publisherName = idea.publisherName,
    rating = idea.rating,
    onClick = onClick,
)

data class IdeaCardContent(
    val idea: Idea,
    val categories: List<Category>,
    val favourite: Boolean,
)

@Serializable
data class Idea(
    val name: String,
    val creator: String,
    val authors: List<String>?,
    val imagePath: String?,
    val rating: Int? = null,
    val links: List<Link>? = null,
    val developerName: String? = null,
    val publisherName: String? = null,
)
