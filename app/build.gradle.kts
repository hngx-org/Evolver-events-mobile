plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.evolver.eventsapp"
    compileSdk = 33

    defaultConfig {
        configurations.all {
            resolutionStrategy {
                force("androidx.emoji2:emoji2-views-helper:1.3.0")
                force("androidx.emoji2:emoji2:1.3.0")
            }
        }
        applicationId = "com.evolver.eventsapp"
        minSdk = 27
        //noinspection OldTargetApi
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose_compiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    /*Standard Dependencies*/

    //core
    implementation(Libs.core_ktx)
    implementation(Libs.core_appcompat)
    implementation(Libs.core_splashscreen)

    // Material Design
    implementation(Libs.compose_material3)
    implementation(Libs.compose_material_icons)

    // Compose
    implementation(platform(Libs.compose))
    implementation(Libs.compose_activity)
    implementation(Libs.compose_graphics)
    implementation(Libs.compose_ui)
    implementation(Libs.compose_ui_tooling_preview)

    debugImplementation(Libs.compose_ui_tooling)
    androidTestImplementation(platform(Libs.compose))

    // lifecycle
    implementation(Libs.lifecycle_runtime)
    implementation(Libs.lifecycle_viewmodel)
    implementation(Libs.lifecycle_viewmodel_compose)

    // Test
    testImplementation(Libs.junit)
    testImplementation(Libs.junit_engine)
    androidTestImplementation(Libs.junit_android)
    androidTestImplementation(Libs.espresso)
    androidTestImplementation(Libs.compose_ui_test_junit)
    debugImplementation(Libs.compose_ui_test_manifest)

    /* Additional Dependencies */
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //coin
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

}