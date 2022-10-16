package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency

import io.github.tuguzd.gamegenbulb.buildconfig.android.implementation.implementation
import io.github.tuguzd.gamegenbulb.buildconfig.android.implementation.kapt
import org.gradle.api.artifacts.dsl.DependencyHandler

object Hilt {
    private const val version = "2.44"

    private const val compiler = "com.google.dagger:hilt-android-compiler:$version"
    private const val dependency = "com.google.dagger:hilt-android:$version"

    fun DependencyHandler.hiltImplementation() {
        kapt(compiler)
        implementation(dependency)
    }

    const val plugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
}
