plugins {
    id("stackoverflow.android.application")
    id("stackoverflow.android.hilt")
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.lukaveli.stackoverflow"

    defaultConfig {
        applicationId = "com.lukaveli.stackoverflow"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":feature:users"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)

    debugImplementation(libs.androidx.compose.ui.tooling)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}
