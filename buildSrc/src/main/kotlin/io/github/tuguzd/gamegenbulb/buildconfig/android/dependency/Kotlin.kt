package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency

object Kotlin {
    object X {
        private const val version = "1.6.4"
        const val group = "org.jetbrains.kotlinx"

        object Coroutine {
            private const val coroutines = "kotlinx-coroutines"

            const val core = "$group:$coroutines-core:$version"
            const val android = "$group:$coroutines-android:$version"
            const val playServices = "$group:$coroutines-play-services:$version"

            object Test {
                const val dependency = "$group:$coroutines-test:$version"
                const val excludedModule = "$coroutines-debug"
            }
        }

        const val serializationJson = "$group:kotlinx-serialization-json:1.4.1"
    }

    object CompilerExtension { const val version = "1.3.2" }
    const val logger = "io.github.microutils:kotlin-logging-jvm:3.0.2"
}
