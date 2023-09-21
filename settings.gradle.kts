@file:Suppress("UnstableApiUsage")
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "EventsApp"
include(":app")
include(":feature:timeline")
include(":core:widgets")
include(":core:util")
include(":core:navigation")
include(":core:data:remote")
include(":feature:signup")
include(":feature:settings")
include(":feature:calendar")
include(":feature:comments")
include(":feature:mypeople")
include(":feature:events")
