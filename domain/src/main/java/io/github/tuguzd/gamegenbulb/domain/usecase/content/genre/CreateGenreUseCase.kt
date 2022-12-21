package io.github.tuguzd.gamegenbulb.domain.usecase.content.genre

import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.repository.GenreRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.crud.CreateUseCase

public class CreateGenreUseCase(
    genreRepository: GenreRepository
) :
    CreateUseCase<Genre>(genreRepository)
