package com.evolver.eventsapp.model

data class EventsData(
    val data: List<Event>,
    val message: String,
    val status: String
)

data class CreateEventsData(
    val data: Event,
    val message: String,
    val status: String
)