package io.github.tuguzd.gamegenbulb.domain.usecase.content.mode

import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.repository.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.crud.CreateUseCase

public class CreateModeUseCase(
    modeRepository: ModeRepository
) :
    CreateUseCase<Mode>(modeRepository)
