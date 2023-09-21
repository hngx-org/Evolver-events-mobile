package com.evolver.eventsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.settingsGraph(
    navController: NavHostController,
) {

    navigation(startDestination = SettingsScreen.route, route = SettingsGraph.route) {

        composable(route = SettingsScreen.route) {
            com.evolver.eventsapp.ui.settings.SettingsScreen()
        }
    }
}