object Version {
    // standard libraries
    const val compose = "2023.09.00"
    const val compose_activity = "1.7.2"
    const val compose_compiler = "1.5.3"
    const val core_appcompat = "1.6.1"
    const val core_ktx = "1.10.0"
    const val core_splash_screen = "1.0.1"
    const val coroutines_core = "1.6.4"
    const val espresso = "3.5.1"
    const val gradle_plugin = "8.1.1"
    const val junit = "5.9.2"
    const val junit_test = "1.1.5"
    const val kotlin_version = "1.9.10"
    const val lifecycle = "2.6.2"

    // additional libraries

}


object Libs{
    //Core
    const val core_appcompat = "androidx.appcompat:appcompat:${Version.core_appcompat}"
    const val core_ktx = "androidx.core:core-ktx:${Version.core_ktx}"
    const val core_splashscreen = "androidx.core:core-splashscreen:${Version.core_splash_screen}"

    // Compose
    const val compose = "androidx.compose:compose-bom:${Version.compose}"
    const val compose_activity = "androidx.activity:activity-compose:${Version.compose_activity}"
    const val compose_graphics = "androidx.compose.ui:ui-graphics"
    const val compose_material3 = "androidx.compose.material3:material3"
    const val compose_material_icons = "androidx.compose.material:material-icons-extended"
    const val compose_ui = "androidx.compose.ui:ui"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling"
    const val compose_ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview"
    const val compose_ui_test_junit = "androidx.compose.ui:ui-test-junit4"
    const val compose_ui_test_manifest = "androidx.compose.ui:ui-test-manifest"

    //Espresso
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"

    //Junit
    const val junit = "org.junit.jupiter:junit-jupiter-api:${Version.junit}"
    const val junit_android = "androidx.test.ext:junit:${Version.junit_test}"
    const val junit_engine = "org.junit.jupiter:junit-jupiter-engine:${Version.junit}"

    //Kotlinx
    const val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines_core}"

    //Lifecycle
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val lifecycle_viewmodel_compose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}"

}

object Plugins {
    const val android_application = "com.android.application:${Version.gradle_plugin}"
    const val android_library = "com.android.library:${Version.gradle_plugin}"
    const val kotlin_android = "org.jetbrains.kotlin.android:${Version.kotlin_version}"
}