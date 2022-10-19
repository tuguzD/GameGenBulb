package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.auth.Google
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.googleImplementation() =
    implementation(Google.PlayServices.auth)
