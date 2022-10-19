package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.architecture

object Hilt {
    private const val version = "2.44"
    private const val group = "com.google.dagger:hilt-android"

    const val compiler = "$group-compiler:$version"
    const val dependency = "$group:$version"

    const val plugin = "$group-gradle-plugin:$version"
}
