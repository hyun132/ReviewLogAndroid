// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("lifecycle_version", "2.6.1")
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
}