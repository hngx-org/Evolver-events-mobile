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
import com.evolver.eventsapp.event.EventScreen
import com.evolver.eventsapp.people.PeopleScreen

fun NavGraphBuilder.myPeopleGraph(
    navController: NavHostController,
) {

    navigation(startDestination = MyPeopleScreen.route, route = MyPeopleGraph.route) {

        composable(route = MyPeopleScreen.route) {
           PeopleScreen(navController)
        }
        composable(route = "events") {
            EventScreen(navController)
        }
        composable(route = "comment_screen") {
           CommentScreen()
        }
    }
}