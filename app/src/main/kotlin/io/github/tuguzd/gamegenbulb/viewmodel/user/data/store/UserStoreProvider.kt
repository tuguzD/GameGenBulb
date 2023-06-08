package io.github.tuguzd.gamegenbulb.viewmodel.user.data.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.User
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserFilters
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserId
import io.github.tuguzd.gamegenbulb.domain.model.system.user.entity.UserIdFilters
import io.github.tuguzd.gamegenbulb.domain.model.util.filter.compare.Equal
import io.github.tuguzd.gamegenbulb.domain.model.util.result.Result
import io.github.tuguzd.gamegenbulb.domain.model.util.exception.BaseException
import io.github.tuguzd.gamegenbulb.domain.usecase.system.user.FilterUsers
import io.github.tuguzd.gamegenbulb.viewmodel.util.StoreProvider
import io.github.tuguzd.gamegenbulb.viewmodel.user.data.store.UserStore.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserStoreProvider(
    private val users: FilterUsers,
    private val storeFactory: StoreFactory,
    private val coroutineContext: CoroutineContext,
) : StoreProvider<Intent, State, Label> {
    override fun provide(): UserStore =
        object : UserStore, Store<Intent, State, Label>
        by storeFactory.create(
            name = UserStore::class.simpleName,
            initialState = State(user = null, loading = true),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl,
        ) {}

    private sealed interface Message {
        object Loading : Message
        data class Loaded(val user: User) : Message
        data class NotFound(val id: UserId) : Message
        object Error : Message
    }

    private inner class ExecutorImpl : CoroutineExecutor<Intent, Unit, State, Message, Label>(
        mainContext = coroutineContext,
    ) {
        override fun executeIntent(intent: Intent, getState: () -> State) =
            when (intent) {
                is Intent.Load -> load(intent.id)
            }

        private fun load(id: UserId) {
            dispatch(Message.Loading)
            scope.launch {
                val filters = UserFilters(id = UserIdFilters(eq = Equal(id)))
                val userFlow = when (val result = users.users(filters)) {
                    is Result.Success -> result.data
                    is Result.Error -> {
                        dispatch(Message.Error)
                        when (val error = result.error) {
                            is FilterUsers.Exception.Repository -> when (error.error) {
                                is BaseException.LocalStore -> publish(Label.LocalStoreError)
                                is BaseException.NetworkAccess -> publish(Label.NetworkAccessError)
                                is BaseException.Unknown -> publish(Label.UnknownError)
                            }
                        }
                        return@launch
                    }
                }
                userFlow.collect { users ->
                    val user = users.firstOrNull()
                    if (user == null) {
                        dispatch(Message.NotFound(id))
                        publish(Label.NotFound(id))
                        return@collect
                    }
                    dispatch(Message.Loaded(user))
                }
            }
        }
    }

    private object ReducerImpl : Reducer<State, Message> {
        override fun State.reduce(msg: Message): State =
            when (msg) {
                Message.Loading -> copy(loading = true)
                is Message.Loaded -> copy(user = msg.user, loading = false)
                is Message.NotFound -> copy(user = null, loading = false)
                Message.Error -> copy(loading = false)
            }
    }
}
