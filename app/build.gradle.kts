import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Kotlin
import io.github.tuguzd.gamegenbulb.buildconfig.android.implementation.*

plugins {
    id("com.android.application")
    kotlin("android")
    // id("com.google.relay") version "0.3.01"
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33
    namespace = "io.github.tuguzd.gamegenbulb.app"

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
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Must-have Android dependencies
    appImplementation()
    // Clean Architecture layers
    implementation(project(":data"))
    implementation(project(":domain"))

    // Kotlin extensions
    implementation(Kotlin.X.Coroutine.android)
    implementation(Kotlin.X.Coroutine.playServices)

    // Dependency Injection (DI)
    hiltImplementation()

    // Jetpack Compose
    composeCoreImplementation()
    materialDesignImplementation()
    navigationImplementation()
    // Additional features for Jetpack Compose
    composeThirdPartyImplementation()
    accompanistFeatureImplementation()

    // Authentication
    googleImplementation()

    // Quality Assurance
    androidTestImplementation(Kotlin.X.Coroutine.Test.dependency) {
        exclude(
            group = Kotlin.X.group,
            module = Kotlin.X.Coroutine.Test.excludedModule
        )
    }
    appLoggingImplementation()
    unitTestingImplementation()
    instrumentTestingImplementation()
}
