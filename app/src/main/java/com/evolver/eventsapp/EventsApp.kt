package com.evolver.eventsapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.evolver.eventsapp.ui.theme.EventsAppBottomNav
import com.evolver.eventsapp.ui.theme.EventsAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController
){

    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        content = { offsetPadding->

            EventsAppNavHost(
                modifier = Modifier
                    .padding(offsetPadding)
                    .fillMaxSize(),
                navController =navController
            )
        },
        bottomBar = {
            EventsAppBottomNav(
                currentBackStackEntry = currentBackStackEntry,
                navController = navController
            )
                    },

        snackbarHost = {
            SnackbarHostState()
        }
    )
}

@Preview
@Composable
fun PreviewEventsApp(){
    EventsAppTheme {
        EventsApp(navController = rememberNavController())
    }
}