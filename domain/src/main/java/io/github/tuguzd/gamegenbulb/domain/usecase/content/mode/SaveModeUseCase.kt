package io.github.tuguzd.gamegenbulb.domain.usecase.content.mode

import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.repository.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.crud.SaveUseCase

public class SaveModeUseCase(
    modeRepository: ModeRepository
) :
    SaveUseCase<Mode>(modeRepository)
