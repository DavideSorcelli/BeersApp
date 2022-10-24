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

    // coroutines
    implementation(Dependencies.COROUTINES)

}