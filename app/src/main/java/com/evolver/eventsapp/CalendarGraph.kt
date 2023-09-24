package com.evolver.eventsapp

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.evolver.eventsapp.ui.calendar.CalendarScreen
import com.evolver.eventsapp.ui.calendar.CalendarViewModel
import java.time.LocalDate

fun NavGraphBuilder.calendarGraph(
    navController: NavHostController,
) {

    navigation(startDestination = CalendarScreen.route, route = CalendarGraph.route) {
        composable(route = CalendarScreen.route) {

            val viewModel = viewModel<CalendarViewModel>()

            val onUpdateMonth =
                { month: LocalDate ->
                    viewModel.updateDisplayedMonth(month)

                }

            val onDayClicked = remember {
                { day: Int ->
                    viewModel.onDayClick(day)
                }
            }

            CalendarScreen(
                onDayClick = onDayClicked,
                state = viewModel.state.collectAsState().value,
                updateMonth = onUpdateMonth,
                onSearchClick = { },
                updateQuery = viewModel::updateQuery
            )
        }
    }
}