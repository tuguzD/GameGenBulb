package io.github.tuguzd.gamegenbulb.domain.repository.content

import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.SearchRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.ReadRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.UpdateRepository

public interface ModeRepository :
    ReadRepository<Mode>, UpdateRepository<Mode>, SearchRepository<Mode>
