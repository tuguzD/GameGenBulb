package io.github.tuguzd.gamegenbulb.app.di.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.data.GameRemoteMediator
import io.github.tuguzd.gamegenbulb.data.datasource.local.*
import io.github.tuguzd.gamegenbulb.data.datasource.remote.IgdbGameDataSource
import io.github.tuguzd.gamegenbulb.data.repository.*
import io.github.tuguzd.gamegenbulb.domain.repository.*

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideGameRepository(
        remoteDataSource: IgdbGameDataSource,
        localDataSource: LocalGameDataSource,
    ): GameRepository = GameRepositoryImpl(remoteDataSource, localDataSource)

    @Provides
    fun provideModeRepository(
//        remoteDataSource: IgdbModeDataSource,
        localDataSource: LocalModeDataSource,
    ): ModeRepository = ModeRepositoryImpl(localDataSource)

    @Provides
    fun provideGenreRepository(
//        remoteDataSource: IgdbGenreDataSource,
        localDataSource: LocalGenreDataSource,
    ): GenreRepository = GenreRepositoryImpl(localDataSource)

    @Provides
    fun provideGameRemoteMediator(
        remoteDataSource: IgdbGameDataSource,
        localDataSource: LocalGameDataSource,
    ): GameRemoteMediator = GameRemoteMediator(remoteDataSource, localDataSource)
}
