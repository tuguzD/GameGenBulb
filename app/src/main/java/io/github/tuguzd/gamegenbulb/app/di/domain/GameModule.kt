package io.github.tuguzd.gamegenbulb.app.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.domain.repository.GameRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.content.game.*

@Module
@InstallIn(SingletonComponent::class)
object GameModule {
    @Provides
    fun provideSaveGame(repository: GameRepository):
        SaveGameUseCase = SaveGameUseCase(repository)

    @Provides
    fun provideGetGame(repository: GameRepository):
        GetGameUseCase = GetGameUseCase(repository)

    @Provides
    fun provideSearchGame(repository: GameRepository):
        SearchGameUseCase = SearchGameUseCase(repository)

    @Provides
    fun provideReadAllGame(repository: GameRepository):
        ReadAllGameUseCase = ReadAllGameUseCase(repository)
}
