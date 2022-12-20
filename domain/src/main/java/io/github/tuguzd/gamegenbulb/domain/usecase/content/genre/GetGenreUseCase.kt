package io.github.tuguzd.gamegenbulb.domain.usecase.content.genre

import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.repository.content.GenreRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.crud.ReadUseCase

public class GetGenreUseCase(
    genreRepository: GenreRepository
) :
    ReadUseCase<Genre>(genreRepository)
