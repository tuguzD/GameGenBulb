package io.github.tuguzd.gamegenbulb.app.view.screen.main.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.EmojiEmotions
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
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
            text = game.name.toString(), maxLines = 2,
            style = MaterialTheme.typography.titleLarge,
        )
        if (game.genres.isNotEmpty() || game.modes.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                mainAxisSpacing = 8.dp,
                crossAxisSpacing = (-8).dp,
            ) {
                game.genres.forEach { genre ->
                    ElevatedAssistChip(
                        leadingIcon = {
                            Icon(Icons.Rounded.MenuBook, contentDescription = "")
                        }, onClick = { }, label = { Text(genre.name.toString()) }
                    )
                }
                game.modes.forEach { mode ->
                    ElevatedAssistChip(
                        leadingIcon = {
                            Icon(Icons.Rounded.EmojiEmotions, contentDescription = "")
                        }, onClick = { }, label = { Text(mode.name.toString()) }
                    )
                }
            }
        }
    }
}
