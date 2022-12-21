package io.github.tuguzd.gamegenbulb.app.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.data.datasource.interfaces.GameDataSource
import io.github.tuguzd.gamegenbulb.data.datasource.remote.GameIgdbDataSource
import io.github.tuguzd.gamegenbulb.data.datasource.remote.IgdbApiClient

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    fun provideIgdbApi(): IgdbApiClient = IgdbApiClient()

    @Provides
    fun provideGameIgdbDataSource(client: IgdbApiClient):
        GameDataSource = GameIgdbDataSource(client)
}
