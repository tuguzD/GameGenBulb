package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.remote

object Fuel {
    private const val version = "2.3.1"
    private const val group = "com.github.kittinunf.fuel:fuel"

    object Core {
        const val core = "$group:$version"
        const val android = "$group-android:$version"
    }

    object Kotlin {
        const val coroutine = "$group-coroutines:$version"
        const val serialization = "$group-kotlinx-serialization:$version"
    }
}
