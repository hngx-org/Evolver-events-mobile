package com.evolver.eventsapp.repository

import com.evolver.eventsapp.model.EventsData
import com.evolver.eventsapp.network.EventApi
import com.evolver.eventsapp.utils.Resource
import retrofit2.Response
import javax.inject.Inject

class EventRepository @Inject constructor(private val eventApi: EventApi) {

    suspend fun getEvents() : Resource<Response<EventsData>>{
        val response = eventApi.getEvents()
        try {
            if (response.isSuccessful){
                Resource.Success(data = response.body()!!)
            }
        }catch (e:Exception){
          //  Resource.Failure(exception = e)
        }
        return Resource.Success(data = response)
    }
}