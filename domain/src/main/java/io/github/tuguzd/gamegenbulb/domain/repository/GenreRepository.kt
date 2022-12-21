package io.github.tuguzd.gamegenbulb.domain.repository

import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.ReadAllRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.SearchRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.CreateRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.ReadRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.UpdateRepository

public interface GenreRepository :
    CreateRepository<Genre>, ReadRepository<Genre>, UpdateRepository<Genre>,
    SearchRepository<Genre>, ReadAllRepository<Genre>
