package com.evolver.eventsapp.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolver.eventsapp.model.EventItem
import com.evolver.eventsapp.model.EventsData
import com.evolver.eventsapp.repository.EventRepository
import com.evolver.eventsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(private val repository: EventRepository) : ViewModel(){

    private val _event = MutableLiveData<Resource<EventsData>>()
    val event: LiveData<Resource<EventsData>> = _event

    init {
        viewModelScope.launch {
            repository.getEvents()
        }
    }

    fun getEventsList() = viewModelScope.launch {
        _event.postValue(Resource.Loading())
        _event.postValue(Resource.Success(data = repository.getEvents().data!!.body()!!))
    }

}