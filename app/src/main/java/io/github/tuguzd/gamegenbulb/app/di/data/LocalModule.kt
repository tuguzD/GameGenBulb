package io.github.tuguzd.gamegenbulb.app.di.data

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.data.datasource.local.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun provideClient(@ApplicationContext context: Context):
        DatabaseClient = DatabaseClient(context)

    @Provides
    fun provideGameDataSource(client: DatabaseClient):
        LocalGameDataSource = LocalGameDataSource(client)

    @Provides
    fun provideModeDataSource(client: DatabaseClient):
        LocalModeDataSource = LocalModeDataSource(client)

    @Provides
    fun provideGenreDataSource(client: DatabaseClient):
        LocalGenreDataSource = LocalGenreDataSource(client)
}
