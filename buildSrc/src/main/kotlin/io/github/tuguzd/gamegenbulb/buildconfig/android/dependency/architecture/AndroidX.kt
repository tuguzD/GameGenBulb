package io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.architecture

object AndroidX {
    const val core = "androidx.core:core-ktx:1.9.0"
    const val splashScreen = "androidx.core:core-splashscreen:1.0.0"

    const val security = "androidx.security:security-crypto:1.0.0"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"

    object Pagination {
        private const val version = "3.1.1"
        private const val group = "androidx.paging:paging"

        const val app = "$group-runtime:$version"
        const val test = "$group-common:$version"
    }

    object Log {
        const val logger = "org.slf4j:slf4j-android:1.7.36"
    }

    object UnitTest {
        const val jUnit = "androidx.test.ext:junit:1.1.3"
    }
}
