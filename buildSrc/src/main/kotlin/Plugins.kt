import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.application: PluginDependencySpec get() = id("com.android.application")

val PluginDependenciesSpec.hilt: PluginDependencySpec get() = id("com.google.dagger.hilt.android")

val PluginDependenciesSpec.`kotlin-android`: PluginDependencySpec get() = id("org.jetbrains.kotlin.android")

val PluginDependenciesSpec.`kotlin-jvm`: PluginDependencySpec get() = id("org.jetbrains.kotlin.jvm")

val PluginDependenciesSpec.kotlin: PluginDependencySpec get() = id("kotlin")

val PluginDependenciesSpec.`android-library`: PluginDependencySpec get() = id("com.android.library")
