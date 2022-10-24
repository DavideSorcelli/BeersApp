plugins {
    `android-library`
    `kotlin-android`
    kotlin("kapt")
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

    // retrofit (http client)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.CONVERTER_MOSHI)

    // moshi (json parsing)
    implementation(Dependencies.MOSHI)
}