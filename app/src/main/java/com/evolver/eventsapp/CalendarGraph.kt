package com.evolver.eventsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.calendarGraph(
    navController: NavHostController,
) {

    navigation(startDestination = CalendarScreen.route, route = CalendarGraph.route) {

        composable(route = CalendarScreen.route) {
            Box(modifier = Modifier.fillMaxSize().background(Color.Green))
        }
    }
}