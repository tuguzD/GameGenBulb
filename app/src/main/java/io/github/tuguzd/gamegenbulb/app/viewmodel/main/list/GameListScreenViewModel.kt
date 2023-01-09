package io.github.tuguzd.gamegenbulb.app.viewmodel.main.list

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.usecase.content.game.ReadAllGameUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class GameListScreenViewModel @Inject constructor(
    private val readAllGameUseCase: ReadAllGameUseCase,
) : ViewModel() {
    private var _state by mutableStateOf(GameListState())
    val state get() = _state

    init { update() }

    private fun update() {
        val games = Pager(PagingConfig(pageSize = 20)) {
            GamePagingSource(readAllGameUseCase)
        }.flow
        _state = state.copy(games = games)
    }
}

@Immutable
data class GameListState(
    val games: Flow<PagingData<Game>> = flow {},
)
