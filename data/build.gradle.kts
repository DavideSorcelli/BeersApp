plugins {
    `java-library`
    kotlin
}

java {
    sourceCompatibility = AppConfig.JAVA_VERSION
    targetCompatibility = AppConfig.JAVA_VERSION
}

dependencies {

    // clean architecture layers dependencies
    implementation(project(":domain"))

    // coroutines
    implementation(Dependencies.COROUTINES)
    testImplementation(TestDependencies.COROUTINES)

    // java inject (dependency injection without android dependencies)
    implementation(Dependencies.JAVA_INJECT)

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.MOCKK)
}