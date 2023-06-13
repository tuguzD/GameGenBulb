package io.github.tuguzd.gamegenbulb.view.screen.game.util

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph
annotation class GameNavGraph(
    val start: Boolean = false,
)
