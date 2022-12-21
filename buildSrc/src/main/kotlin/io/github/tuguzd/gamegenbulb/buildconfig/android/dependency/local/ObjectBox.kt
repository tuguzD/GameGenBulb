package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.local

object ObjectBox {
    private const val version = "3.5.0"
    private const val path = "io.objectbox:objectbox"

    const val plugin = "$path-gradle-plugin:$version"

    const val debug = "$path-android-objectbrowser:$version"
    const val release = "$path-android:$version"
}
