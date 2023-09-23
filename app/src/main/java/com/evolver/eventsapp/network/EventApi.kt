package com.evolver.eventsapp.network

import com.evolver.eventsapp.model.EventsData
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton
@Singleton
interface EventApi {
        @GET(value = "api/events")
        suspend fun getEvents() : Response<EventsData>
}
