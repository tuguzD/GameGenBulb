package io.github.tuguzd.gamegenbulb.app.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.domain.repository.GenreRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.content.genre.GetGenreUseCase
import io.github.tuguzd.gamegenbulb.domain.usecase.content.genre.SaveGenreUseCase

@Module
@InstallIn(SingletonComponent::class)
object GenreModule {
    @Provides
    fun provideSaveGenre(repository: GenreRepository):
        SaveGenreUseCase = SaveGenreUseCase(repository)

    @Provides
    fun provideGetGenre(repository: GenreRepository):
        GetGenreUseCase = GetGenreUseCase(repository)
}
