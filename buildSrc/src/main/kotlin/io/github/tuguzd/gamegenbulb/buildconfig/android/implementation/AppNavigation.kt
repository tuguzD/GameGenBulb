package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.JetpackCompose
import org.gradle.api.artifacts.dsl.DependencyHandler

// Provide navigation by pairing Jetpack Compose and Hilt
fun DependencyHandler.composeHiltNavigationImplementation() {
    implementation(JetpackCompose.Features.navigation)
    implementation(JetpackCompose.ThirdParty.navigationHilt)
}

// Provide navigation theming with the help of Accompanist
fun DependencyHandler.accompanistNavigationImplementation() {
    implementation(JetpackCompose.Accompanist.Navigation.material)
    implementation(JetpackCompose.Accompanist.Navigation.animation)
}

// Provide complete navigation feature while using Jetpack Compose
fun DependencyHandler.navigationImplementation() {
    accompanistNavigationImplementation()
    composeHiltNavigationImplementation()
}
