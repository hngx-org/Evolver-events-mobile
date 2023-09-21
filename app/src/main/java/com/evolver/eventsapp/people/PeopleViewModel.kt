package com.evolver.eventsapp.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evolver.eventsapp.model.EventItem
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PeopleViewModel: ViewModel() {
    private val _eventList = MutableStateFlow(events)

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    @OptIn(FlowPreview::class)
    val eventList  = searchText
        .onEach { _isSearching.update { true } }
        .combine(_eventList){ text, eventList ->
            if (text.isBlank())
                eventList
            else{
                eventList.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(3000),
            _eventList.value
        )

    fun onSearchTextChange(text : String){
        _searchText.value = text
    }
}

val events = listOf(
    EventItem("Party","20:02:2020","10a.m","Old Trafford"),
    EventItem("Movie","20:02:2020","10a.m","Old Trafford"),
    EventItem("Date Night","20:02:2020","10a.m","Old Trafford"),
    EventItem("Football","20:02:2020","10a.m","Old Trafford"),
    EventItem("Swimming","20:02:2020","10a.m","Maracana"),
    EventItem("Party","20:02:2020","10a.m","Old Trafford"),
    EventItem("Movie","20:02:2020","10a.m","Old Trafford"),
    EventItem("Date Night","20:02:2020","10a.m","Old Trafford"),
    EventItem("Football","20:02:2020","10a.m","Old Trafford"),
    EventItem("Swimming","20:02:2020","10a.m","Maracana")

)