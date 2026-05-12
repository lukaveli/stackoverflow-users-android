import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                "implementation"("com.google.dagger:hilt-android:2.56.2")
                "kapt"("com.google.dagger:hilt-android-compiler:2.56.2")
            }
        }
    }
}
