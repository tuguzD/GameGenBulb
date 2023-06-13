package io.github.tuguzd.gamegenbulb.view.util.card.analysis

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import de.charlex.compose.RevealDirection
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.util.HiddenContentColumn
import io.github.tuguzd.gamegenbulb.view.util.RevealSwipe
import io.github.tuguzd.gamegenbulb.view.util.button.FavouriteIconButton
import io.github.tuguzd.gamegenbulb.view.util.button.TooltipIconButton
import io.github.tuguzd.gamegenbulb.view.util.card.analysis.util.AnalysisInfo
import io.github.tuguzd.gamegenbulb.view.util.card.analysis.util.PositionInfo
import kotlinx.serialization.Serializable

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun AnalysisCard(
    analysis: IdeaAnalysis,
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
            PositionInfo(
                position = analysis.position,
                listSize = analysis.listSize,
            )
            AnalysisInfo(
                ideaName = analysis.ideaName,
                criterion = analysis.criterion,
                listType = analysis.listType,
                timePassed = analysis.timePassed,
            )
        }
    }
}

@Serializable
data class IdeaAnalysis(
    val ideaName: String,
    val criterion: String,
    val position: Int,
    val listSize: Int,
    val listType: String,
    val timePassed: String,
)
