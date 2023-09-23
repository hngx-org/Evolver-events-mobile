package com.evolver.eventsapp.model

data class Event(
    val created_at: String,
    val creator_id: String,
    val description: String,
    val end_date: String,
    val end_time: String,
    val id: String,
    val location: String,
    val start_date: String,
    val start_time: String,
    val title: String,
    val updated_at: String
)