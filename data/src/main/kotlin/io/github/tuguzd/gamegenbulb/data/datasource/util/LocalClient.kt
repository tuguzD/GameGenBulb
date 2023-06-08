@file:Suppress("unused")

package io.github.tuguzd.gamegenbulb.data.datasource.util

import android.content.Context
import io.github.tuguzd.gamegenbulb.data.BuildConfig
import io.github.tuguzd.gamegenbulb.data.model.MyObjectBox
import io.github.tuguzd.gamegenbulb.data.model.game.data.GameEntity
import io.github.tuguzd.gamegenbulb.data.model.system.user.UserEntity
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.android.Admin
import io.objectbox.kotlin.boxFor

class LocalClient(context: Context) {
    private val boxStore: BoxStore = MyObjectBox.builder()
        .androidContext(context)
        .build()
        .apply {
            if (BuildConfig.DEBUG) {
                Admin(this).start(context)
            }
        }

    internal val userBox: Box<UserEntity> = boxStore.boxFor()
    internal val gameBox: Box<GameEntity> = boxStore.boxFor()
}
