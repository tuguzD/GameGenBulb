package io.github.tuguzd.gamegenbulb.buildconfig.android.implementation

import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.JetpackCompose
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Kotlin
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.QualityAssurance
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.architecture.AndroidX
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.remote.Retrofit
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.unitTestingImplementation() {
    testImplementation(QualityAssurance.UnitTest.jUnit4)
    androidTestImplementation(AndroidX.UnitTest.jUnit)
}

fun DependencyHandler.appLoggingImplementation() {
    implementation(Kotlin.logger)
    implementation(AndroidX.Log.logger)
}

fun DependencyHandler.dataLoggingImplementation() {
    implementation(Retrofit.Logging.interceptor)
}

fun DependencyHandler.instrumentTestingImplementation() {
    debugImplementation(JetpackCompose.InstrumentTest.layout)
    androidTestImplementation(JetpackCompose.InstrumentTest.jUnit4)
}
