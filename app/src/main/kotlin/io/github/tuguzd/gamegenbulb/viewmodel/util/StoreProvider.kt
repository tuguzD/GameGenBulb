package io.github.tuguzd.gamegenbulb.viewmodel.util

import com.arkivanov.mvikotlin.core.store.Store

fun interface StoreProvider<in Intent : Any, out State : Any, out Label : Any> {
    fun provide(): Store<Intent, State, Label>
}
