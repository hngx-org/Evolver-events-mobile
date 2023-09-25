package com.evolver.eventsapp.ui.create_events

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolver.eventsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateEventViewModel @Inject constructor(
    private val repository: CreateRepository
) : ViewModel() {

    private val _vmstate = MutableStateFlow(EventEntity())
    val vmstate = _vmstate.asStateFlow()

    fun updateEntity(state: EventEntity) {
        _vmstate.update { state }
    }

    private val _status = MutableStateFlow("success")
    private val _message = MutableStateFlow("Event created")

    private val entity = combine(
        flow = _vmstate,
        flow2 = _message,
        flow3 = _status,
        transform = { event, message, status ->
            CreateEventsEntity(
                data = listOf(event.toEvent()),
                msg = message,
                status = status
            )
        }
    )

    fun createEvent() {
        viewModelScope.launch {
            Log.i("CreateEventViewModel","TO BE posted = ${_vmstate.value}")
            Log.i("CreateEventViewModel","TO BE posted2 = ${entity.first()}")
            repository.postEvent(createEventsEntity = entity.first()).collect{ result ->
                _vmstate.update { state ->
                    when(result) {
                        is Resource.Error -> {
                            state.copy(
                                serverError = result.message ?:"Unexpected error occurred, try again.",
                                isLoading = false,
                                )
                        }
                        is Resource.Failure -> {
                            state.copy(
                                serverError = result.message ?:"Unexpected failure occurred, try again.",
                                isLoading = false,
                            )
                        }
                        is Resource.Loading -> {
                            state.copy(isLoading = true)
                        }
                        is Resource.Success -> {
                            Log.i("CreateEventViewModel", "Successfully posted = $state")
                            state.copy(showSuccessDialog = true)
                        }
                        is Resource.Timeout -> {
                            state.copy(
                                serverError = result.message ?:"Request timeout, try again.",
                                isLoading = false,
                            )
                        }
                    }
                }
            }
        }
    }
}