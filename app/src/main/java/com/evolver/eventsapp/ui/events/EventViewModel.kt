package com.evolver.eventsapp.ui.events

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EventViewModel: ViewModel() {

    private val _state = MutableStateFlow(EventState())
    val state = _state.asStateFlow()

    fun updateEventState(state: EventState) {
        _state.update { state }
    }

    fun onAddLocation() {
        //Todo
    }

}