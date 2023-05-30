@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.junit5)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.apollo.graphql)
}
kapt {
    useBuildCache = true
    correctErrorTypes = true
    showProcessorStats = true
}

dependencies {
    // Clean Architecture layers
    implementation(project(":domain"))

    // Android implementation
    implementation(libs.core.ktx)

    // DataStore implementation (one of those below)
    implementation(libs.bundles.encr.shared.pref)
    implementation(libs.bundles.encr.datastore.prot)
    implementation(libs.bundles.encr.datastore.pref)
    // Apollo Client implementation
    implementation(libs.apollo.runtime)
    // ObjectBox implementation
    implementation(libs.objectbox.kotlin)
    debugImplementation(libs.objectbox.android.objectbrowser)
    releaseImplementation(libs.objectbox.android)

    // General testing implementation
    // JUnit 4 implementation
    testImplementation(libs.junit4)
    // JUnit 5 implementation
    testImplementation(libs.bundles.junit5.core)
    testRuntimeOnly(libs.bundles.junit5.engine)
}
apply(plugin = libs.plugins.objectbox.get().pluginId)

val dataNamespace: String = libs.versions.namespace.get() + ".data"
apollo {
    service("service") {
        packageName.set(dataNamespace)
    }
}

@Suppress("UnstableApiUsage")
android {
    namespace = dataNamespace
    compileSdk = libs.versions.sdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()

        testInstrumentationRunner =
            libs.versions.test.runner.get()
        testInstrumentationRunnerArguments["runnerBuilder"] =
            libs.versions.test.args.get()

        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlin {
        jvmToolchain(18)
    }
}
