plugins {
    `java-library`
    kotlin
    kotlin("kapt")
}

java {
    sourceCompatibility = AppConfig.JAVA_VERSION
    targetCompatibility = AppConfig.JAVA_VERSION
}

dependencies {

    // clean architecture layers dependencies
    implementation(project(":domain"))

}