package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.remote.API
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.remote.Fuel
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.remote.Retrofit
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.retrofitImplementation() {
    implementation(Retrofit.dependency)
    implementation(Retrofit.ThirdParty.kotlinXSerializationConverter)
    implementation(Retrofit.ThirdParty.networkResponseAdapter)
}

fun DependencyHandler.apiImplementation() {
    implementation(API.igdb)
}

fun DependencyHandler.fuelImplementation() {
    implementation(Fuel.Core.core)
    implementation(Fuel.Core.android)
    implementation(Fuel.Kotlin.coroutine)
    implementation(Fuel.Kotlin.serialization)
}
