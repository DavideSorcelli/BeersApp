import org.gradle.api.JavaVersion

object AppConfig {
    val JAVA_VERSION = JavaVersion.VERSION_11
    const val COMPILE_SDK = 33
    const val TARGET_SDK = 33
    const val MIN_SDK = 24
    const val RELEASE = "release"
    const val DEBUG = "debug"
}