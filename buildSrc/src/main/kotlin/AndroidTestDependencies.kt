object AndroidTestDependencies {
    const val JUNIT = "androidx.test.ext:junit:${Versions.JUNIT_ANDROID}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val COMPOSE = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime-testing:${Versions.LIFECYCLE}"
    const val ROOM = "androidx.room:room-testing:${Versions.ROOM}"
    const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"
    const val MOCKK_AGENT = "io.mockk:mockk-agent:${Versions.MOCKK}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
    const val HILT = "com.google.dagger:hilt-android-testing:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
}