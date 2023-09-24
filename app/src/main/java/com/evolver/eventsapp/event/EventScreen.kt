package com.evolver.eventsapp.event

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.evolver.eventsapp.people.EventScreenContent
import com.evolver.eventsapp.people.PeopleAppBar
import com.evolver.eventsapp.utils.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen(navController: NavController = rememberNavController()) {
    val colors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = Color(0xFFFFC6BC))
    val eventsViewModel : EventsViewModel = hiltViewModel()
    val eventResource by eventsViewModel.event.observeAsState()

    LaunchedEffect(key1 = true){
        eventsViewModel.getEventsList()
    }

    when (eventResource){
        is Resource.Error -> {}
        is Resource.Failure -> {}
        is Resource.Loading -> {
            Log.d("Test event data", "EventScreen: loadingggg")
            CircularProgressIndicator()
        }
        is Resource.Success -> {
            val eventData = (eventResource as Resource.Success).data
            eventData!!.data.forEach {
                Log.d("Test event data", "EventScreen: ${it.description}")
            }

        }
        is Resource.Timeout -> {}
        null -> {}
    }

    Scaffold(
        topBar = { PeopleAppBar(
            isEventScreen = true,
            isPeopleScreen = false,
            title = "Techie",
            colors = colors,
            textColor = Color.Black,
            iconTint = Color.Black){
            navController.popBackStack()
        }},
        modifier = Modifier

            .fillMaxSize()
            .background(Color(0xFF3F3849))) {
        Surface(modifier = Modifier.padding(it)) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .background(color = Color(0xFFFFC6BC))
            )
            Spacer(modifier = Modifier.height(6.dp))
            EventScreenContent(eventResource) {
                navController.navigate("comment_screen")
                //TODO : NAVIGATE TO COMMENT PAGE
            }
        }
    }
}
