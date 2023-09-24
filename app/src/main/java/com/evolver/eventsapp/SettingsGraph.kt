package com.evolver.eventsapp


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.evolver.eventsapp.ui.settings.SettingsScreen

fun NavGraphBuilder.settingsGraph(
    navController: NavHostController,
) {

    navigation(startDestination = SettingsScreen.route, route = SettingsGraph.route) {

        composable(route = SettingsScreen.route) {
            SettingsScreen(navController)
        }
    }
}