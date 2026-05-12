plugins {
    id("stackoverflow.android.library")
    id("stackoverflow.android.hilt")
}

android {
    namespace = "com.lukaveli.stackoverflow.core.domain"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
