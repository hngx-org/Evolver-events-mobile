package com.evolver.eventsapp.ui.create_events

import com.evolver.eventsapp.model.Event
import java.time.LocalDate
import java.time.LocalTime

data class CreateEventsEntity(
    val data: List<Event> = listOf(),
    val message: String = "Events retrieved successfully",
    val status: String = "success",
)

data class EventEntity(
    val createdAt: String = "",
    val creatorId: String = "",
    val description: String = "", // will be used
    val endDate: LocalDate = LocalDate.now(), //will be used
    val endTime: LocalTime = LocalTime.now(), //will be used
    val id: String = "",
    val location: String = "", // will be used
    val startDate: LocalDate = LocalDate.now(), //will be used
    val startTime: LocalTime = LocalTime.now(), //will be used
    val title: String = "", //will be used
    val updatedAt: String = "",
    val isLoading: Boolean = false,
    val serverError: String = "",
    val showSuccessDialog: Boolean = false,
)

//Map Entity to event to avoid posting nothing
fun EventEntity.toEvent(): Event {
    return Event(
        created_at = this.createdAt,
        creator_id = this.creatorId,
        description = this.description,
        end_date = this.endDate.toString(),
        end_time = this.endTime.toString(),
        id = this.id,
        location = this.location,
        start_date = this.startDate.toString(),
        start_time = this.startTime.toString(),
        title = this.title,
        updated_at = this.updatedAt
    )
}