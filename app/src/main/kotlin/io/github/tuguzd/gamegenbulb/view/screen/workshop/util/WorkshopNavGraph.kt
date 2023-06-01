@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.workshop.util

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph
annotation class WorkshopNavGraph(
    val start: Boolean = false,
)
