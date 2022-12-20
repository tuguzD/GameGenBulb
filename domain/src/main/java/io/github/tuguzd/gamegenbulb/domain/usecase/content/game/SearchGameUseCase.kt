package io.github.tuguzd.gamegenbulb.domain.usecase.content.game

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.repository.content.GameRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.business.SearchUseCase

public class SearchGameUseCase(
    gameRepository: GameRepository
) :
    SearchUseCase<Game>(gameRepository)
