package com.evolver.eventsapp.ui.create_events

import android.util.Log
import com.evolver.eventsapp.model.CreateEventsData
import com.evolver.eventsapp.network.EventApi
import com.evolver.eventsapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class CreateEventRepositoryImpl @Inject constructor(
    private val eventApi: EventApi
): CreateRepository {

    override suspend fun postEvent(createEventsEntity: CreateEventsEntity) : Flow<Resource<Response<CreateEventsData>>> = flow {
        try {
            emit(Resource.Loading())
            Log.i("CreateEventRepository","TO BE posted = ${createEventsEntity.toCreateEventsData()}")
            val response = eventApi.postEvent(createEventsEntity.toCreateEventsData())
            if (response.isSuccessful) {
                emit(Resource.Success(data = response))
            } else {
                val failure: Resource<Response<CreateEventsData>> = Resource.Failure(Exception("Unsuccessful response"))
                emit(failure)
            }
        } catch (e: Exception) {
            val failure: Resource<Response<CreateEventsData>> = Resource.Failure(e)
            Log.e("CreateEventRepository", "Post Event failed: $e")
            emit(failure)
        }
    }.flowOn(Dispatchers.IO)

}

