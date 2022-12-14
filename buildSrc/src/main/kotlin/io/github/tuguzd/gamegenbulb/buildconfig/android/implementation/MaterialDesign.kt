package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.JetpackCompose
import org.gradle.api.artifacts.dsl.DependencyHandler

// Provide app theming with Material 3
fun DependencyHandler.materialThemeImplementation() {
    implementation(JetpackCompose.Material.You.dependency)
    implementation(JetpackCompose.Material.You.resizableLayout)
}

// Provide Material icons for use without downloading files
fun DependencyHandler.materialIconImplementation() {
    implementation(JetpackCompose.Material.Icons.dependency)
    implementation(JetpackCompose.Material.Icons.extension)
}

// Provide features to build complete Material app
fun DependencyHandler.materialDesignImplementation() {
    implementation(JetpackCompose.Material.core)
    materialIconImplementation()
    materialThemeImplementation()
}
