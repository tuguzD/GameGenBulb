package io.github.tuguzd.gamegenbulb.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.data.datasource.util.LocalClient
import io.github.tuguzd.gamegenbulb.data.datasource.util.RemoteClient
import io.github.tuguzd.gamegenbulb.data.repository.system.user.MockCurrentUserRepository
import io.github.tuguzd.gamegenbulb.data.repository.system.user.MockUserRepository
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.CurrentUserRepository
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun providesLocalClient(@ApplicationContext context: Context): LocalClient =
        LocalClient(context)

    @Singleton
    @Provides
    fun providesRemoteClient(): RemoteClient =
        RemoteClient("http://localhost:8080/graphql")

    @Singleton
    @Provides
    fun provideUserRepository(): UserRepository = MockUserRepository()

    @Singleton
    @Provides
    fun provideCurrentUserRepository(): CurrentUserRepository = MockCurrentUserRepository()
}
