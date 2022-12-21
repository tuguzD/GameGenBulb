package io.github.tuguzd.gamegenbulb.app.di.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.domain.repository.ModeRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.content.mode.CreateModeUseCase
import io.github.tuguzd.gamegenbulb.domain.usecase.content.mode.GetModeUseCase
import io.github.tuguzd.gamegenbulb.domain.usecase.content.mode.UpdateModeUseCase

@Module
@InstallIn(SingletonComponent::class)
object ModeModule {
    @Provides
    fun provideCreateMode(repository: ModeRepository):
        CreateModeUseCase = CreateModeUseCase(repository)

    @Provides
    fun provideGetMode(repository: ModeRepository):
        GetModeUseCase = GetModeUseCase(repository)

    @Provides
    fun provideUpdateMode(repository: ModeRepository):
        UpdateModeUseCase = UpdateModeUseCase(repository)
}
