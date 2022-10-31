plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    hilt
}

android {
    namespace = "it.reply.beersapp.framework"
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName(AppConfig.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.JAVA_VERSION
        targetCompatibility = AppConfig.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = AppConfig.JAVA_VERSION.toString()
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))

    // coroutines
    implementation(Dependencies.COROUTINES)

    // room (database)
    implementation(Dependencies.ROOM_RUNTIME)
    implementation(Dependencies.ROOM_KTX)
    kapt(Dependencies.ROOM_COMPILER)

    // retrofit (http client)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.CONVERTER_MOSHI)
    implementation(Dependencies.MOSHI_KOTLIN)

    // okhttp interceptor (network logging)
    implementation(Dependencies.LOGGING_INTERCEPTOR)

    // moshi (json parsing)
    implementation(Dependencies.MOSHI)

    // hilt (dependency injection)
    implementation(Dependencies.HILT_ANDROID)
    kapt(Dependencies.HILT_COMPILER)

    // timber (logging)
    implementation(Dependencies.TIMBER)

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.COROUTINES)
    testImplementation(TestDependencies.MOCKK)
    testImplementation(TestDependencies.ROOM)

    androidTestImplementation(AndroidTestDependencies.JUNIT)
    androidTestImplementation(AndroidTestDependencies.COROUTINES)
    androidTestImplementation(AndroidTestDependencies.MOCKK_AGENT)
    androidTestImplementation(AndroidTestDependencies.MOCKK_ANDROID)
    androidTestImplementation(AndroidTestDependencies.ROOM)

}