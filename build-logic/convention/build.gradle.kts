plugins {
    `kotlin-dsl`
}

group = "com.lukaveli.stackoverflow.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.7.3")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.10")
    compileOnly("org.jetbrains.kotlin:compose-compiler-gradle-plugin:2.2.10")
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "stackoverflow.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "stackoverflow.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "stackoverflow.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "stackoverflow.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}
