package io.github.tuguzd.gamegenbulb.app.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.data.datasource.remote.IgdbApiClient
import io.github.tuguzd.gamegenbulb.data.datasource.remote.IgdbGameDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideIgdbApi(): IgdbApiClient = IgdbApiClient()

    @Provides
    fun provideGameIgdbDataSource(client: IgdbApiClient):
        IgdbGameDataSource = IgdbGameDataSource(client)

//    @Provides
//    fun provideModeIgdbDataSource(client: IgdbApiClient):
//        IgdbModeDataSource = IgdbModeDataSource(client)
//
//    @Provides
//    fun provideGenreIgdbDataSource(client: IgdbApiClient):
//        IgdbGenreDataSource = IgdbGenreDataSource(client)
}
