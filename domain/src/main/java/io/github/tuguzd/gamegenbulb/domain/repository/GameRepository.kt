package io.github.tuguzd.gamegenbulb.domain.repository

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.ReadAllRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.SearchRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.ReadRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.SaveRepository

public interface GameRepository :
    SaveRepository<Game>, ReadRepository<Game>,
    SearchRepository<Game>, ReadAllRepository<Game>
