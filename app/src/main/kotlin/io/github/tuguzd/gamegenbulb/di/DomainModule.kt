package io.github.tuguzd.gamegenbulb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.CurrentUserRepository
import io.github.tuguzd.gamegenbulb.domain.repository.system.user.UserRepository
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.FilterUsers
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.current.*
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.sign.*

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun provideSignIn(
        userRepository: UserRepository,
        currentUserRepository: CurrentUserRepository,
    ) = SignIn(userRepository, currentUserRepository)

    @Provides
    fun provideSignUp(
        userRepository: UserRepository,
        currentUserRepository: CurrentUserRepository,
    ) = SignUp(userRepository, currentUserRepository)

    @Provides
    fun provideSignOut(
        userRepository: UserRepository,
        currentUserRepository: CurrentUserRepository,
    ) = SignOut(userRepository, currentUserRepository)

    @Provides
    fun provideUpdateCurrentUser(
        userRepository: UserRepository,
        currentUserRepository: CurrentUserRepository,
    ) = UpdateCurrentUser(userRepository, currentUserRepository)

    @Provides
    fun provideDeleteCurrentUser(
        userRepository: UserRepository,
        currentUserRepository: CurrentUserRepository,
    ) = DeleteCurrentUser(userRepository, currentUserRepository)

    @Provides
    fun provideFilterUsers(
        repository: UserRepository
    ) = FilterUsers(repository)

    @Provides
    fun provideGetCurrentUser(
        repository: CurrentUserRepository
    ) = GetCurrentUser(repository)
}
