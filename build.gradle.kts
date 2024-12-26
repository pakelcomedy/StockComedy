buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.2")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.1")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
}