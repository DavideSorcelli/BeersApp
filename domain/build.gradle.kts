plugins {
    `java-library`
    kotlin
}

java {
    sourceCompatibility = AppConfig.JAVA_VERSION
    targetCompatibility = AppConfig.JAVA_VERSION
}

dependencies {

    // coroutines
    implementation(Dependencies.COROUTINES)

    // java inject (dependency injection without android dependencies)
    implementation(Dependencies.JAVA_INJECT)

}