package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.JetpackCompose
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.composeCoreImplementation() {
    implementation(JetpackCompose.Core.ui)
    implementation(JetpackCompose.Core.activity)

    // Basic features of Jetpack Compose
    implementation(JetpackCompose.Features.pagination)

    // Android Studio integrations with Jetpack Compose
    implementation(JetpackCompose.AndroidStudio.preview)
    debugImplementation(JetpackCompose.AndroidStudio.tooling)
}

fun DependencyHandler.composeThirdPartyImplementation() {
    implementation(JetpackCompose.ThirdParty.coil)
    implementation(JetpackCompose.ThirdParty.scalableDp)
    implementation(JetpackCompose.ThirdParty.SharedElement.dependency)
}

fun DependencyHandler.accompanistFeatureImplementation() {
    implementation(JetpackCompose.Accompanist.pager)
    implementation(JetpackCompose.Accompanist.placeholder)
    implementation(JetpackCompose.Accompanist.refreshSwipe)
}
