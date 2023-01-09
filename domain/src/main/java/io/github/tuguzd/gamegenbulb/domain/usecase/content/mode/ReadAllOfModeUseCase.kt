package io.github.tuguzd.gamegenbulb.domain.usecase.content.mode

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.repository.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.business.ReadAllOfUseCase

public class ReadAllOfModeUseCase(
    modeRepository: ModeRepository
) :
    ReadAllOfUseCase<Game, Mode>(modeRepository)
