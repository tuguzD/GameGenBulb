package io.github.tuguzd.gamegenbulb.data.datasource.local

import android.content.Context
import io.github.tuguzd.gamegenbulb.data.BuildConfig
import io.github.tuguzd.gamegenbulb.data.model.local.*
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.android.Admin
import io.objectbox.kotlin.boxFor

public class DatabaseClient(context: Context) {
    internal val boxStore: BoxStore = MyObjectBox.builder()
        .androidContext(context)
        .build().apply {
            if (BuildConfig.DEBUG) {
                Admin(this).start(context)
            }
        }

    internal val gameBox: Box<GameEntity> = boxStore.boxFor()
    internal val modeBox: Box<ModeEntity> = boxStore.boxFor()
    internal val genreBox: Box<GenreEntity> = boxStore.boxFor()
}
