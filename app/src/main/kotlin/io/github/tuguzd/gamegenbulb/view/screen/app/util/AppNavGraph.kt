@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.app.util

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph
annotation class AppNavGraph(
    val start: Boolean = false,
)
