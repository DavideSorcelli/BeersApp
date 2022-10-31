object TestDependencies {
    const val LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime-testing:${Versions.LIFECYCLE}"
    const val ROOM = "androidx.room:room-testing:${Versions.ROOM}"
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
    const val HILT = "com.google.dagger:hilt-android-testing:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
}