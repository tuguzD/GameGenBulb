package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.local.Room
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.roomImplementation() {
    implementation(Room.dependency)
    kapt(Room.compiler)
}
