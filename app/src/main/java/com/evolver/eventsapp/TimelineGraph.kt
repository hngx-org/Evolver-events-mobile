package com.evolver.eventsapp

import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.evolver.eventsapp.ui.timeline.TimeLineScreen

fun NavGraphBuilder.timelineGraph(
    navController: NavHostController,
) {

    navigation(startDestination = TimelineScreen.route, route = TimelineGraph.route) {

        composable(route = TimelineScreen.route) {

            val onAddEventClicked = remember {
                {
                    navController.navigate(CreateEventGraph.route)
                }
            }

            TimeLineScreen(onAddEventClick = onAddEventClicked)
        }
    }
}