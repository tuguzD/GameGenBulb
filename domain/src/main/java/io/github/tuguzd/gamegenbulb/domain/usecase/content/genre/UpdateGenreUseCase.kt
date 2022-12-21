package io.github.tuguzd.gamegenbulb.domain.usecase.content.genre

import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.repository.GenreRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.crud.UpdateUseCase

public class UpdateGenreUseCase(
    genreRepository: GenreRepository
) :
    UpdateUseCase<Genre>(genreRepository)
