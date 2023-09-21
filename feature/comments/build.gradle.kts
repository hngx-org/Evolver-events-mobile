plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.feature.comments"
    compileSdk = 33

    defaultConfig {
        minSdk = 27

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        maybeCreate("release").apply {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    /*Standard Dependencies*/
    implementation(Libs.core_ktx)
    implementation(Libs.core_appcompat)
    implementation(Libs.compose_material3)
    implementation(Libs.compose_material_icons)
    testImplementation(Libs.junit)
    testImplementation(Libs.junit_engine)
    androidTestImplementation(Libs.junit_android)
    androidTestImplementation(Libs.espresso)
}