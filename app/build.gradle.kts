@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
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
    // Android implementation
    implementation(libs.bundles.core)
    implementation(libs.bundles.lifecycle)
    implementation(libs.activity.compose)

    // DataStore implementation
    implementation(libs.bundles.encr.shared.pref)
    implementation(libs.bundles.encr.datastore.prot)
    implementation(libs.bundles.encr.datastore.pref)

    // Third-party implementation
    implementation(libs.coil)
    implementation(libs.bundles.mvi)
    implementation(libs.bundles.hilt)
    kapt(libs.hilt.kapt)

    // Jetpack Compose implementation
    val composeBom = platform(libs.compose.bom)
    implementation(composeBom)
    implementation(libs.bundles.compose.impl)
    implementation(libs.material.icons)
    implementation(libs.bundles.material3)

    // Jetpack Compose addon implementation
    implementation(libs.accompanist.placeholder)
    implementation(libs.destinations.core)
    ksp(libs.destinations.ksp)

    // General testing implementation
    testImplementation(libs.junit)
    debugImplementation(libs.bundles.compose.debug)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.bundles.junit.android)
}

@Suppress("UnstableApiUsage")
android {
    namespace = libs.versions.namespace.get()
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        applicationId = libs.versions.namespace.get()
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner =
            libs.versions.test.runner.get()
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
