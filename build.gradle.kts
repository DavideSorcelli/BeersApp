// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    application version Versions.GRADLE apply false
    `android-library` version Versions.GRADLE apply false
    `kotlin-android` version Versions.KOTLIN apply false
    hilt version Versions.HILT apply false
    `kotlin-jvm` version Versions.KOTLIN apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}