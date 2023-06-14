package io.github.tuguzd.gamegenbulb.view.util.card.session

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.charlex.compose.RevealDirection
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.HiddenContentColumn
import io.github.tuguzd.gamegenbulb.view.util.RevealSwipe
import io.github.tuguzd.gamegenbulb.view.util.button.FavouriteIconButton
import io.github.tuguzd.gamegenbulb.view.util.button.TooltipIconButton
import io.github.tuguzd.gamegenbulb.view.util.card.session.util.CompletionInfo
import io.github.tuguzd.gamegenbulb.view.util.card.session.util.ParticipantInfo
import io.github.tuguzd.gamegenbulb.view.util.card.session.util.SessionInfo
import io.github.tuguzd.gamegenbulb.view.util.card.user.util.ExpandColumn
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SessionCard(
    session: Session,
    isFavourite: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
) = RevealSwipe(
    hiddenContentStart = {
        HiddenContentColumn {
            var favouriteState by remember { mutableStateOf(isFavourite) }
            FavouriteIconButton(favouriteState) {
                favouriteState = !favouriteState
            }
            TooltipIconButton(
                imageVector = Icons.Rounded.Share,
                contentDescription = stringResource(R.string.share),
            )
        }
    },
    hiddenContentEnd = {
        HiddenContentColumn {
            TooltipIconButton(
                imageVector = Icons.Rounded.Edit,
                contentDescription = stringResource(R.string.edit),
            )
            TooltipIconButton(
                imageVector = Icons.Rounded.Delete,
                contentDescription = stringResource(R.string.delete),
            )
        }
    },
    directions = setOf(
        RevealDirection.StartToEnd,
        RevealDirection.EndToStart,
    ),
) {
    ElevatedCard(
        modifier = modifier,
        onClick = onClick,
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            CompletionInfo(session.tasksCompleted)
            SessionInfo(
                mainTaskName = session.mainTaskName,
                methodName = session.methodName,
                ideaCount = session.ideaCount,
                duration = session.duration,
            )
        }
        if (!session.participants.isNullOrEmpty())
            Surface(tonalElevation = 1.dp) {
                var expandedState by remember { mutableStateOf(false) }
                ExpandColumn(
                    expandedState = expandedState,
                    onClick = { expandedState = !expandedState },
                    text = "Участники и их роли",
                ) {
                    ParticipantInfo(
                        admin = session.admin,
                        participants = session.participants,
                    )
                }
            }
    }
}

@Serializable
data class Session(
    val mainTaskName: String,
    val tasksCompleted: Boolean,
    val methodName: String,
    val duration: String,
    val ideaCount: String?,
    val admin: String,
    val participants: List<String>?,
)
