package com.evolver.eventsapp.ui.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.create_events.EventState
import com.evolver.eventsapp.ui.create_events.util.timeToString
import com.evolver.eventsapp.ui.theme.EventsAppTheme
import java.time.LocalDate
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier,
    onDayClick: (Int) -> Unit,
    state: CalendarState?,
    updateMonth: (LocalDate) -> Unit,
    onSearchClick: () -> Unit,
    updateQuery: (String) -> Unit,
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.calendar),
                        style = MaterialTheme.typography.titleLarge,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        content = { scaffoldPadding ->
            Column(
                modifier = modifier.verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceEvenly,
                content = {
                    Box(
                        modifier = modifier
                            .background(color = MaterialTheme.colorScheme.primary),
                        content = {
                            if (state != null) {
                                Column(
                                    modifier = modifier
                                        .padding(scaffoldPadding)
                                        .padding(12.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    content = {
                                        CalendarSearchBar(
                                            searchQuery = state.query,
                                            onSearchQueryChanged = {
                                                updateQuery(it)
                                            },
                                            onSearchClicked = onSearchClick
                                        )

                                        CalendarView(
                                            modifier = modifier
                                                .fillMaxWidth()
                                                .aspectRatio(0.7f),
                                            onDayClick = onDayClick,
                                            onPreviousMonthClick = {
                                                val previousMonthDate = state.date.minusMonths(1)
                                                if (previousMonthDate != null) {
                                                    updateMonth(previousMonthDate)
                                                }
                                            },
                                            onNextMonthClick = {
                                                val nextMonthDate = state.date.plusMonths(1)
                                                if (nextMonthDate != null) {
                                                    updateMonth(nextMonthDate)
                                                }
                                            },
                                            eventDate = state.date,
                                        )

                                    }
                                )
                            }
                        }
                    )

                    Spacer(modifier = modifier.height(15.dp))
                    //Card//for each day click, inflate the events, it can be a lazy column


                    state?.events?.forEach {
                        Box(
                            modifier = modifier.padding(12.dp),
                            content = {
                                EventCardItem(
                                    eventDescription = it.eventDescription,
                                    eventLocation = it.eventLocation,
                                    startTime = it.startTime.timeToString(),
                                    endTime = it.endTime.timeToString()
                                )
                            }
                        )
                    }


                })
        })
}


@Preview(showBackground = true)
@Composable
fun PreviewCalendarScreen() {
    EventsAppTheme {
        CalendarScreen(
            onDayClick = { },
            state =  mockCalendarList()[0],
            updateMonth = { },
            updateQuery = { },
            onSearchClick = { }
        )
    }
}


fun mockCalendarList(): List<CalendarState> {
    val calendarInputs = mutableListOf<CalendarState>()
    for (i in 1..  31) {
        calendarInputs.add(
            CalendarState(
                day = i,
                events = listOf(
                    EventState(
                        eventDescription = "Movie Night",
                        eventLocation = "Genesis cinemas, Festac",
                        startTime = LocalTime.now(),
                        endTime = LocalTime.now(),
                    ),
                    EventState(
                        eventDescription = "Coding Night",
                        eventLocation = "HNG, Nigeria",
                        startTime = LocalTime.now(),
                        endTime = LocalTime.now(),
                    )
                )
            )
        )
    }
    return calendarInputs
}