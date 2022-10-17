import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.AndroidX.androidXImplementation
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Google.googleImplementation
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Hilt.hiltImplementation
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.JetpackCompose
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Kotlin
import io.github.tuguzd.gamegenbulb.buildconfig.android.implementation.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33
    namespace = "io.github.tuguzd.gamegenbulb"

    defaultConfig {
        applicationId = "io.github.tuguzd.gamegenbulb"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Kotlin.CompilerExtension.version
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Must-have Android dependencies
    androidXImplementation()

    // Jetpack Compose
    composeCoreImplementation()
    materialDesignImplementation()
    navigationImplementation()

    // Additional features for Jetpack Compose
    composeThirdPartyImplementation()
    accompanistFeatureImplementation()

    // Kotlin extensions
    implementation(Kotlin.X.coroutine)
    implementation(Kotlin.X.playServices)
    implementation(Kotlin.X.serializationJson)

    // Dependency injection
    hiltImplementation()

    // Google
    googleImplementation()

    // Data layer
    implementation(project(":domain"))

    // Quality Assurance
    androidTestImplementation(Kotlin.X.Test.coroutine) {
        exclude(group = Kotlin.X.group, module = Kotlin.X.Test.excludedModule)
    }
    loggingImplementation()
    unitTestingImplementation()
    instrumentTestingImplementation()
}

kapt {
    correctErrorTypes = true
}
