package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.architecture.AndroidX
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.architecture.Hilt
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.hiltImplementation() {
    kapt(Hilt.compiler)
    implementation(Hilt.dependency)
}

fun DependencyHandler.dataImplementation() {
    implementation(AndroidX.core)
    implementation(AndroidX.security)
}

fun DependencyHandler.appImplementation() {
    implementation(AndroidX.core)
    implementation(AndroidX.lifecycle)
    implementation(AndroidX.splashScreen)
}
