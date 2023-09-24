package com.evolver.eventsapp.ui.calendar

import com.evolver.eventsapp.ui.create_events.EventState
import java.time.LocalDate


data class CalendarState(
    val date: LocalDate = LocalDate.now(),
    val day: Int? = null,
    val events: List<EventState> = emptyList(),
    val query: String = ""
)
