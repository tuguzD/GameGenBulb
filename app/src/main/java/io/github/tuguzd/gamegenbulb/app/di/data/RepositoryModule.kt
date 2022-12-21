package io.github.tuguzd.gamegenbulb.app.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.GameDataSource
import io.github.tuguzd.gamegenbulb.data.repository.GameRepositoryImpl
import io.github.tuguzd.gamegenbulb.domain.repository.GameRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideGameRepository(dataSource: GameDataSource):
        GameRepository = GameRepositoryImpl(dataSource)
}
