package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.architecture

object AndroidX {
    const val core = "androidx.core:core-ktx:1.9.0"
    const val splashScreen = "androidx.core:core-splashscreen:1.0.0"

    const val security = "androidx.security:security-crypto:1.0.0"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    const val pagination = "androidx.paging:paging-runtime:3.1.1"

    object Log {
        const val logger = "org.slf4j:slf4j-android:1.7.36"
    }
    object UnitTest {
        const val jUnit = "androidx.test.ext:junit:1.1.3"
    }
}
