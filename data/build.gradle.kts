import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.AndroidX.androidXDataImplementation
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Kotlin
import io.github.tuguzd.gamegenbulb.buildconfig.android.implementation.*

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("plugin.serialization")
    kotlin("kapt")
}

android {
    compileSdk = 33
    namespace = "io.github.tuguzd.gamegenbulb.data"

    defaultConfig {
        minSdk = 23
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Must-have Android dependencies
    androidXDataImplementation()

    // Kotlin extensions
    implementation(Kotlin.X.serializationJson)

    // Clean Architecture layers
    implementation(project(":domain"))

    // Persistence
    roomImplementation()

    // Retrofit
    retrofitImplementation()

    // Quality Assurance
    androidTestImplementation(Kotlin.X.Test.coroutine) {
        exclude(group = Kotlin.X.group, module = Kotlin.X.Test.excludedModule)
    }
    loggingImplementation()
    unitTestingImplementation()
}
