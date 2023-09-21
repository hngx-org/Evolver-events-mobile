package com.evolver.eventsapp

/**
 * Destination objects hold all  information about a destination like route name, arguments, e.t.c
 */

interface EventsAppDestination{
    val route:String
}


object TimelineScreen:EventsAppDestination{
    override val route="timeline"
    // TODO : Add other information for this route e.g any navigation argument needed
}

object MyPeopleScreen:EventsAppDestination{
    override val route="myPeople"
    // TODO : Add other information for this route e.g any navigation argument needed
}

object CalendarScreen:EventsAppDestination{
    override val route="calendar"
    // TODO : Add other information for this route e.g any navigation argument needed
}

object SettingsScreen:EventsAppDestination{
    override val route="settings"
    // TODO : Add other information for this route e.g any navigation argument needed
}

object TimelineGraph:EventsAppDestination{
    override val route="timelineGraph"
}

object MyPeopleGraph:EventsAppDestination{
    override val route="myPeopleGraph"
}

object CalendarGraph:EventsAppDestination{
    override val route="calendarGraph"
}

object SettingsGraph:EventsAppDestination{
    override val route="settingsGraph"
}