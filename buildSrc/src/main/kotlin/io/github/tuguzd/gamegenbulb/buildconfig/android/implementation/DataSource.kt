package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Retrofit
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Room
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.retrofitImplementation() {
    implementation(Retrofit.dependency)
    implementation(Retrofit.ThirdParty.kotlinXSerializationConverter)
    implementation(Retrofit.ThirdParty.networkResponseAdapter)
}

fun DependencyHandler.roomImplementation() {
    implementation(Room.dependency)
    kapt(Room.compiler)
}
