package io.github.tuguzd.gamegenbulb.domain.usecase.content.mode

import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.repository.content.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.crud.ReadUseCase

public class GetModeUseCase(
    modeRepository: ModeRepository
) :
    ReadUseCase<Mode>(modeRepository)
