package com.evolver.eventsapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun EventsAppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController

){

    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = TimelineGraph.route
    ){
        // TODO : Add your navigation graph as appropriate
        timelineGraph(navController)
        myPeopleGraph(navController)
        calendarGraph(navController)
        settingsGraph(navController)
    }
}