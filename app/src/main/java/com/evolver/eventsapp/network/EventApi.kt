package com.evolver.eventsapp.network

import com.evolver.eventsapp.model.CreateEventsData
import com.evolver.eventsapp.model.EventsData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import javax.inject.Singleton
@Singleton
interface EventApi {
        @GET(value = "api/events")
        suspend fun getEvents() : Response<EventsData>

        @POST(value = "api/events")
        suspend fun postEvent( @Body createEventsData: CreateEventsData): Response<CreateEventsData>
}
