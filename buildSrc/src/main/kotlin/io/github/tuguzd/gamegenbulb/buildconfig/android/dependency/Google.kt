package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency

import io.github.tuguzd.gamegenbulb.buildconfig.android.implementation.implementation
import org.gradle.api.artifacts.dsl.DependencyHandler

object Google {
    object PlayServices {
        const val auth = "com.google.android.gms:play-services-auth:20.3.0"
    }

    fun DependencyHandler.googleImplementation() =
        implementation(PlayServices.auth)
}
