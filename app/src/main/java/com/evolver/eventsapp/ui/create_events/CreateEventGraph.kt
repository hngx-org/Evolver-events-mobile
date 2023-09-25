package com.evolver.eventsapp.ui.create_events

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.evolver.eventsapp.CreateEventGraph
import com.evolver.eventsapp.CreateEventScreen

fun NavGraphBuilder.createEventGraph(
    navController: NavHostController,
) {

    navigation(startDestination = CreateEventScreen.route, route = CreateEventGraph.route) {

        composable(route = CreateEventScreen.route) {

            val viewModel: CreateEventViewModel = hiltViewModel()
            val state = viewModel.vmstate.collectAsState().value

            val onBack: () -> Unit = remember {
                {
                    navController.navigateUp()
                }
            }


            val onSaveEvent: () -> Unit = remember {
                {
                    viewModel.createEvent()
                }
            }

            CreateEvent(
                onBack = onBack,
                state = state,
                updateState = viewModel::updateEntity,
                onGroupsClick = { /*TODO add people screen */ },
                onCreateEvent = onSaveEvent
            )
        }
    }
}