package com.evolver.eventsapp.ui.events

import java.time.LocalDate
import java.time.LocalTime


data class EventState(
    val eventDescription: String = "",
    val startDate: LocalDate = LocalDate.now(),
    val startTime: LocalTime = LocalTime.now(),
    val endDate: LocalDate = LocalDate.now(),
    val endTime: LocalTime = LocalTime.now(),
)
