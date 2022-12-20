package io.github.tuguzd.gamegenbulb.domain.usecase.content.game

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.repository.content.GameRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.crud.ReadUseCase

public class GetGameUseCase(
    gameRepository: GameRepository
) :
    ReadUseCase<Game>(gameRepository)
