package com.evolver.eventsapp

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.evolver.eventsapp.ui.onboarding.SignInScreen
import com.evolver.eventsapp.ui.onboarding.SplashScreen

@Composable
fun EventsAppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController

){

    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = SplashScreen.route
    ){
        // TODO : Add your navigation graph as appropriate

        composable(route = SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(route = SignInScreen.route) {
            SignInScreen(navController)
        }

        timelineGraph(navController)
        myPeopleGraph(navController)
        calendarGraph(navController)
        settingsGraph(navController)
    }
}

class MockNavController(ctx:Context): NavHostController(ctx)