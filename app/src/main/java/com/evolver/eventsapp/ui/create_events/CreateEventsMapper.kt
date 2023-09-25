package com.evolver.eventsapp.ui.create_events

import com.evolver.eventsapp.model.CreateEventsData

//  Map data to the DTO (create_eventsData)
// this is to avoid posting empty values to the endpoint
fun CreateEventsEntity.toCreateEventsData(): CreateEventsData {
    return CreateEventsData(
        data = this.data,
        message = this.message,
        status = this.status
    )
}