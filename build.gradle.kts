plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    kotlin("jvm") version "1.7.20" apply false
    kotlin("android") version "1.7.20" apply false
    kotlin("plugin.serialization") version "1.7.20" apply false
}

buildscript {
    dependencies {
        classpath(
            io.github.tuguzd.gamegenbulb.buildconfig
                .android.dependency.local.ObjectBox.plugin
        )
        classpath(
            io.github.tuguzd.gamegenbulb.buildconfig
                .android.dependency.architecture.Hilt.plugin
        )
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
