package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.local.Realm
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.local.Room
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.roomImplementation() {
    implementation(Room.dependency)
    kapt(Room.compiler)
}

fun DependencyHandler.realmImplementation() {
    implementation(Realm.base)
//    implementation(Kotlin.X.Coroutine.core)
}
