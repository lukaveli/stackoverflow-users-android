import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("stackoverflow.android.library")
                apply("stackoverflow.android.hilt")
                apply("org.jetbrains.kotlin.plugin.compose")
            }
        }
    }
}
