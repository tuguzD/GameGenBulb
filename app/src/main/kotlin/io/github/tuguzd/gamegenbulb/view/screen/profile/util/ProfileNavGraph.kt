@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.view.screen.profile.util

import com.ramcosta.composedestinations.annotation.NavGraph
import io.github.tuguzd.gamegenbulb.view.screen.app.util.AppNavGraph

@AppNavGraph
@NavGraph
annotation class ProfileNavGraph(
    val start: Boolean = false,
)
