@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.workshop.util

import com.ramcosta.composedestinations.annotation.NavGraph
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppNavGraph

@AppNavGraph
@NavGraph
annotation class WorkshopNavGraph(
    val start: Boolean = false,
)
