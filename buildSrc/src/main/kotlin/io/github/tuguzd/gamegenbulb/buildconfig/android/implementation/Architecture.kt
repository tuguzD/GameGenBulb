package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.architecture.AndroidX
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.architecture.Hilt
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.hiltImplementation() {
    kapt(Hilt.compiler)
    implementation(Hilt.dependency)
}

private fun DependencyHandler.androidImplementation() {
    implementation(AndroidX.core)
    implementation(AndroidX.pagination)
}

fun DependencyHandler.dataImplementation() {
    androidImplementation()
    implementation(AndroidX.security)
}

fun DependencyHandler.appImplementation() {
    androidImplementation()
    implementation(AndroidX.lifecycle)
    implementation(AndroidX.splashScreen)
}
