package com.evolver.eventsapp.model

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class EventItem(
    var  eventTitle : String,
    var eventDate : String,
    var eventTime : String,
    var eventVenue : String
){
    fun doesMatchSearchQuery(query : String) : Boolean{
        val matchingCombination = listOf(
            eventTitle
        )
        return matchingCombination.any {
            it.contains(query,ignoreCase = true)
        }
    }
}


data class EventCardItem(
    var eventPeopleName : String,
    var eventCount : Int,
    var eventIcon : Painter
)
