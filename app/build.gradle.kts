@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.junit5)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.hilt.android)
}
kapt {
    useBuildCache = true
    correctErrorTypes = true
    showProcessorStats = true
}

dependencies {
    // Clean Architecture layers
    implementation(project(":data"))
    implementation(project(":domain"))

    // Android implementation
    implementation(libs.bundles.core)
    implementation(libs.bundles.lifecycle)
    implementation(libs.activity.compose)

    // Third-party implementation
    implementation(libs.coil)
    implementation(libs.bundles.mvi)
    kapt(libs.hilt.kapt)
    implementation(libs.bundles.hilt)

    val composeBom = platform(libs.compose.bom)
    // Jetpack Compose implementation
    implementation(composeBom)
    implementation(libs.bundles.compose.impl)
    implementation(libs.material.icons)
    implementation(libs.bundles.material3)
    // Jetpack Compose addon implementation
    implementation(libs.accompanist.placeholder)
    implementation(libs.destinations.core)
    ksp(libs.destinations.ksp)

    // General testing implementation
    androidTestImplementation(libs.espresso.core)
    // JUnit 4 implementation
    androidTestImplementation(composeBom)
    testImplementation(libs.junit4)
    debugImplementation(libs.bundles.compose.debug)
    androidTestImplementation(libs.bundles.junit4.android)
    // JUnit 5 implementation
    testImplementation(libs.bundles.junit5.core)
    testRuntimeOnly(libs.bundles.junit5.engine)
    androidTestImplementation(libs.junit5.api)
}

val appNamespace: String = libs.versions.namespace.get()

@Suppress("UnstableApiUsage")
android {
    namespace = appNamespace
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = appNamespace
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            libs.versions.test.runner.get()
        testInstrumentationRunnerArguments["runnerBuilder"] =
            libs.versions.test.args.get()

        vectorDrawables.useSupportLibrary = true
    }

    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion =
        libs.versions.compose.compiler.get()

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlin {
        jvmToolchain(18)
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
