plugins {
    application
    `kotlin-android`
    `kotlin-kapt`
    hilt
}

android {
    namespace = "it.reply.beersapp"

    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = "it.reply.beersapp"
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName(AppConfig.RELEASE) {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    // clean architecture layers dependencies
    implementation(project(":domain"))
    implementation(project(":framework"))

    implementation(Dependencies.CORE_KTX)

    // compose
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.MATERIAL3)
    implementation(Dependencies.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependencies.NAVIGATION_COMPOSE)
    implementation(Dependencies.HILT_NAVIGATION_COMPOSE)
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(Dependencies.SWIPE_REFRESH)

    // lifecycle
    implementation(Dependencies.LIFECYCLE_VIEW_MODEL)
    implementation(Dependencies.VIEW_MODEL_COMPOSE)
    implementation(Dependencies.LIFECYCLE_RUNTIME)
    implementation(Dependencies.LIFECYCLE_COMMON)

    // coroutines
    implementation(Dependencies.COROUTINES)

    // hilt (dependency injection)
    implementation(Dependencies.HILT_ANDROID)
    kapt(Dependencies.HILT_COMPILER)

    // coil (image loading and caching)
    implementation(Dependencies.COIL)
    implementation(Dependencies.COIL_COMPOSE)

    // timber (logging)
    implementation(Dependencies.TIMBER)

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.MOCKK)
    testImplementation(TestDependencies.COROUTINES)
    testImplementation(TestDependencies.LIFECYCLE_RUNTIME)
    testImplementation(TestDependencies.ROOM)
    testImplementation(TestDependencies.HILT)
    kaptTest(TestDependencies.HILT_COMPILER)

    androidTestImplementation(AndroidTestDependencies.LIFECYCLE_RUNTIME)
    androidTestImplementation(AndroidTestDependencies.JUNIT)
    androidTestImplementation(AndroidTestDependencies.ESPRESSO)
    androidTestImplementation(AndroidTestDependencies.COMPOSE)
    androidTestImplementation(AndroidTestDependencies.MOCKK_ANDROID)
    androidTestImplementation(AndroidTestDependencies.MOCKK_AGENT)
    androidTestImplementation(AndroidTestDependencies.ROOM)
    androidTestImplementation(AndroidTestDependencies.COROUTINES)
    androidTestImplementation(AndroidTestDependencies.HILT)
    kaptAndroidTest(AndroidTestDependencies.HILT_COMPILER)

    debugImplementation(DebugDependencies.COMPOSE_UI_TOOLING)
    debugImplementation(DebugDependencies.COMPOSE_UI_TEST_MANIFEST)
}