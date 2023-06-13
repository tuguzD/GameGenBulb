package io.github.tuguzd.gamegenbulb.view.screen.app.workshop.analyzes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.view.screen.app.workshop.util.WorkshopNavGraph
import io.github.tuguzd.gamegenbulb.view.util.NoOverscroll
import io.github.tuguzd.gamegenbulb.view.util.card.analysis.AnalysisCard
import io.github.tuguzd.gamegenbulb.view.util.card.analysis.IdeaAnalysis
import io.github.tuguzd.gamegenbulb.view.util.row.chip.ChipRow
import io.github.tuguzd.gamegenbulb.view.util.scaffold.AddFABScaffold

@WorkshopNavGraph
@Destination
@Composable
fun AnalysisListScreen(
    modifier: Modifier = Modifier,
) = AddFABScaffold(
    label = stringResource(R.string.conduct_new),
    onClick = { },
) {
    Column(modifier = modifier.fillMaxSize()) {
        NoOverscroll {
            ChipRow(
                firstChipName = "Выполненные",
                secondChipName = "Текущие",
                thirdChipName = "Критерий",
            )
        }
        val padding = 16.dp

        LazyColumn(
            modifier = modifier.padding(horizontal = padding),
        ) {
            item { Spacer(modifier = Modifier.height(padding)) }
            item {
                AnalysisCard(
                    analysis = IdeaAnalysis(
                        ideaName = "Minduni",
                        criterion = "Уникальность",
                        position = 24,
                        listSize = 100,
                        listType = "Игры",
                        timePassed = "2 мин. назад",
                    ),
                    isFavourite = false,
                )
                Spacer(modifier = Modifier.height(padding))
            }
        }
    }
}
