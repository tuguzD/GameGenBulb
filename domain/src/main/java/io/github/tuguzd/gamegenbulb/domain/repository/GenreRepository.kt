package io.github.tuguzd.gamegenbulb.domain.repository

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.ReadAllOfRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.SearchRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.ReadRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.SaveRepository

public interface GenreRepository :
    SaveRepository<Genre>, ReadRepository<Genre>,
    SearchRepository<Genre>, ReadAllOfRepository<Game, Genre>
