@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.google.ksp)
}
kapt {
    correctErrorTypes = true
    useBuildCache = true
}

dependencies {
    // Android implementation
    implementation(libs.core.ktx)
    implementation(libs.core.splashscreen)
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.activity.compose)

    // DataStore implementation
    implementation(libs.security.crypto)
    implementation(libs.datastore)
    implementation(libs.datastore.crypto)

    // Third-party implementation
    implementation(libs.coil)
    implementation(libs.hilt)
    implementation(libs.hilt.navigation)
    kapt(libs.hilt.kapt)

    // MVIKotlin implementation
    implementation(libs.mvi)
    implementation(libs.mvi.main)
    implementation(libs.mvi.logging)
    implementation(libs.mvi.coroutines)

    // Jetpack Compose core implementation
    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    implementation(libs.material.icons)
    implementation(libs.material3)
    implementation(libs.material3.window.size)

    // Jetpack Compose addon implementation
    implementation(libs.accompanist.placeholder)
    implementation(libs.destinations.core)
    ksp(libs.destinations.ksp)

    // Testing implementation
    testImplementation(libs.junit)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.junit.ext)
}

@Suppress("UnstableApiUsage")
android {
    namespace = "io.github.tuguzd.gamegenbulb"
    compileSdk = 33

    defaultConfig {
        applicationId = "io.github.tuguzd.gamegenbulb"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
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
