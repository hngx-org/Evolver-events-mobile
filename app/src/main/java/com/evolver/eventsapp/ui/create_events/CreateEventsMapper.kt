package com.evolver.eventsapp.ui.create_events

import com.evolver.eventsapp.model.EventsData

//  Map data to the DTO (eventsData)
// this is to avoid posting empty values to the endpoint
fun CreateEventsEntity.toEventsData(): EventsData {
    return EventsData(
        data = this.data,
        message = this.message,
        status = this.status
    )
}