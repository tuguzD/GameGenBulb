package io.github.tuguzd.gamegenbulb.app.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.domain.repository.GenreRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.content.genre.CreateGenreUseCase
import io.github.tuguzd.gamegenbulb.domain.usecase.content.genre.GetGenreUseCase
import io.github.tuguzd.gamegenbulb.domain.usecase.content.genre.UpdateGenreUseCase

@Module
@InstallIn(SingletonComponent::class)
object GenreModule {
    @Provides
    fun provideCreateGenre(repository: GenreRepository):
        CreateGenreUseCase = CreateGenreUseCase(repository)

    @Provides
    fun provideGetGenre(repository: GenreRepository):
        GetGenreUseCase = GetGenreUseCase(repository)

    @Provides
    fun provideUpdateGenre(repository: GenreRepository):
        UpdateGenreUseCase = UpdateGenreUseCase(repository)
}
