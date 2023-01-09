package io.github.tuguzd.gamegenbulb.domain.usecase.content.game

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.repository.GameRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.crud.SaveUseCase

public class SaveGameUseCase(
    gameRepository: GameRepository
) :
    SaveUseCase<Game>(gameRepository)
