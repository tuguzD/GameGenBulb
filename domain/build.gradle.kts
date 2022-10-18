import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.Kotlin
import io.github.tuguzd.gamegenbulb.buildconfig.android.dependency.QualityAssurance

plugins {
    `java-library`
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlin {
    explicitApi()
}

dependencies {
    implementation(Kotlin.logger)

    testImplementation(QualityAssurance.UnitTest.jUnit4)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
