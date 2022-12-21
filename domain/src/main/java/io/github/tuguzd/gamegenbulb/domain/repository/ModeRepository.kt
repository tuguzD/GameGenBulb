package io.github.tuguzd.gamegenbulb.domain.repository

import io.github.tuguzd.gamegenbulb.domain.model.content.Mode
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.ReadAllRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.SearchRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.CreateRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.ReadRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.UpdateRepository

public interface ModeRepository :
    CreateRepository<Mode>, ReadRepository<Mode>, UpdateRepository<Mode>,
    SearchRepository<Mode>, ReadAllRepository<Mode>
