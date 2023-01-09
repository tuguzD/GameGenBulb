package io.github.tuguzd.gamegenbulb.domain.usecase.content.genre

import io.github.tuguzd.gamegenbulb.domain.model.content.Game
import io.github.tuguzd.gamegenbulb.domain.model.content.Genre
import io.github.tuguzd.gamegenbulb.domain.repository.GenreRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.util.business.ReadAllOfUseCase

public class ReadAllOfGenreUseCase(
    genreRepository: GenreRepository
) :
    ReadAllOfUseCase<Game, Genre>(genreRepository)
