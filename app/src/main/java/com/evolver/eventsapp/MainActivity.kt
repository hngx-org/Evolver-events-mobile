package com.evolver.eventsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.evolver.eventsapp.ui.onboarding.SplashScreen
import com.evolver.eventsapp.people.PeopleScreen
import com.evolver.eventsapp.ui.theme.EventsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventsAppTheme {
                var showLandingScreen by remember { mutableStateOf(true) }
                if (showLandingScreen) {
                   SplashScreen { showLandingScreen = false }
                } else {
                    EventsApp(navController = rememberNavController())
                }

                EventsApp(navController = rememberNavController())
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    EventsApp(navController = navController)
                }
            }
        }
    }
}

