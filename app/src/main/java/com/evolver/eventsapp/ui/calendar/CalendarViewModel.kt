package com.evolver.eventsapp.ui.calendar

import android.util.Log
import androidx.lifecycle.ViewModel
import com.evolver.eventsapp.ui.create_events.EventState
import com.evolver.eventsapp.ui.create_events.util.dateToString
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import java.time.LocalTime

class CalendarViewModel: ViewModel() {

    private val _state = MutableStateFlow(CalendarState())
    val state = _state.asStateFlow()

    private val _listItems = MutableStateFlow<List<CalendarState>>(emptyList())

    init {
        _listItems.update { mockCalendarList() }
    }

    fun updateDisplayedMonth(date: LocalDate) {
        _state.update { it.copy(date = date) }
        Log.i("VIEWMODEL", _state.value.date.dateToString("MMMM yyyy"))
    }

    fun updateQuery(query: String) {
        _state.update { it.copy(query = query) }
    }

    fun onDayClick(day: Int) {
        // Find the clicked day in the list and assign it to dayClicked
        val dayClicked = _listItems.value.firstOrNull { it.day == day }

        if (dayClicked != null) {
            _state.update {   dayClicked }
        }
    }

     private fun mockCalendarList(): List<CalendarState> {
        val calendarInputs = mutableListOf<CalendarState>()
        for (i in 1 ..  _state.value.date.lengthOfMonth()) {
            calendarInputs.add(
                CalendarState(
                    day = i,
                    events = listOf(
                        EventState(
                            eventDescription = "Movie Night",
                            eventLocation = "Genesis cinemas, Festac",
                            startTime = LocalTime.now(),
                            endTime = LocalTime.now(),
                        ),
                        EventState(
                            eventDescription = "Coding Night",
                            eventLocation = "HNG, Nigeria",
                            startTime = LocalTime.now(),
                            endTime = LocalTime.now(),
                        )
                    )
                )
            )
        }
        return calendarInputs
    }
}