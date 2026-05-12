plugins {
    id("stackoverflow.android.feature")
}

android {
    namespace = "com.lukaveli.stackoverflow.feature.users"
}

dependencies {
    implementation(project(":core:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.activity.compose)
    
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Hilt Navigation Compose
    implementation(libs.androidx.hilt.navigation.compose)

    // Image Loading
    implementation(libs.coil.compose)
}
