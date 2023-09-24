package com.evolver.eventsapp.ui.create_events.util

import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun LocalDate.dateToString(pattern: String): String {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return this.format(formatter)
}

fun Long.longToLocalDate(): LocalDate {
    val instant = Instant.ofEpochMilli(this)
    return instant.atZone(ZoneId.systemDefault()).toLocalDate()
}

fun LocalTime.timeToString(): String {
    val formatter = DateTimeFormatter.ofPattern("hh:mm a")
    return this.format(formatter)
}