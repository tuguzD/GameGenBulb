package io.github.tuguzd.gamegenbulb.app.view.screen.main.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.QuestionMark
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.tuguzd.gamegenbulb.domain.model.content.Game

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCard(
    game: Game,
    modifier: Modifier = Modifier,
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit = {},
) = Card(
    modifier = modifier,
    elevation = elevation,
    border = border,
    interactionSource = interactionSource,
    onClick = onClick,
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = game.name.toString(),
            maxLines = 2,
            style = MaterialTheme.typography.titleLarge,
        )
        if (game.genres.isNotEmpty() || game.modes.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
        }
        if (game.genres.isNotEmpty()) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(game.genres, key = { it.id.toString() }) { genre ->
                    AssistChip(
                        leadingIcon = {
                            Icon(Icons.Rounded.QuestionMark, contentDescription = "")
                        },
                        onClick = { }, label = { Text(genre.name.toString()) }
                    )
                }
            }
        }
        if (game.modes.isNotEmpty()) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(game.modes, key = { it.id.toString() }) { mode ->
                    AssistChip(
                        leadingIcon = {
                            Icon(Icons.Rounded.QuestionMark, contentDescription = "")
                        },
                        onClick = { }, label = { Text(mode.name.toString()) }
                    )
                }
            }
        }
    }
}
