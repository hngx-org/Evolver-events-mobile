package com.evolver.eventsapp.ui.create_events

import com.evolver.eventsapp.model.EventsData
import com.evolver.eventsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CreateRepository {

    suspend fun postEvent(createEventsEntity: CreateEventsEntity): Flow<Resource<Response<EventsData>>>
}