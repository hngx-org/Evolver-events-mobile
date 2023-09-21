plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.evolver.eventsapp"
    compileSdk = 34

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
        targetSdk = 34
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
}