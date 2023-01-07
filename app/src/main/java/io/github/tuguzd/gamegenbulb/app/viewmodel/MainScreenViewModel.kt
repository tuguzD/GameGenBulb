package io.github.tuguzd.gamegenbulb.app.viewmodel

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.usecase.content.game.ReadAllGameUseCase
import io.github.tuguzd.gamegenbulb.domain.util.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val readAllGameUseCase: ReadAllGameUseCase,
) : ViewModel() {
    private var _state by mutableStateOf(MainScreenState())
    val state get() = _state

    init { update() }

    private fun update() {
        viewModelScope.launch {
            when (val result = readAllGameUseCase.invoke()) {
                is Result.Error -> throw result.error
                is Result.Success -> {
                    _state = state.copy(games = result.data)
                }
            }
        }
    }
}

@Immutable
data class MainScreenState(
    val games: List<Game> = listOf(),
)
