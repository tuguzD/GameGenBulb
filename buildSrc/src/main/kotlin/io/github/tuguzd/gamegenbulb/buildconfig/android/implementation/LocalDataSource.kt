package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.local.*
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.roomImplementation() {
    implementation(Room.dependency)
    kapt(Room.compiler)
}

fun DependencyHandler.objectBoxImplementation() {
    debugImplementation(ObjectBox.debug)
    releaseImplementation(ObjectBox.release)
}
