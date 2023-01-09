package io.github.tuguzd.gamegenbulb.app.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.domain.repository.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.content.mode.GetModeUseCase
import io.github.tuguzd.gamegenbulb.domain.usecase.content.mode.SaveModeUseCase

@Module
@InstallIn(SingletonComponent::class)
object ModeModule {
    @Provides
    fun provideSaveMode(repository: ModeRepository):
        SaveModeUseCase = SaveModeUseCase(repository)

    @Provides
    fun provideGetMode(repository: ModeRepository):
        GetModeUseCase = GetModeUseCase(repository)
}
