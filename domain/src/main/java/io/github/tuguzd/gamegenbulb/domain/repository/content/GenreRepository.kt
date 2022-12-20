package io.github.tuguzd.gamegenbulb.domain.repository.content

import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.repository.util.business.SearchRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.ReadRepository
import io.github.tuguzd.gamegenbulb.domain.repository.util.crud.UpdateRepository

public interface GenreRepository :
    ReadRepository<Genre>, UpdateRepository<Genre>, SearchRepository<Genre>
