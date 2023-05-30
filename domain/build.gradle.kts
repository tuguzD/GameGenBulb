@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}
kotlin {
    jvmToolchain(18)
}

dependencies {
    implementation(libs.coroutines.core)
    testImplementation(libs.bundles.coroutines.test)
}
