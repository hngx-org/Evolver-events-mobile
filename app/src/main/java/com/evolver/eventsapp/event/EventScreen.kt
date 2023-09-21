package com.evolver.eventsapp.event

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.model.EventItem
import com.evolver.eventsapp.people.EventItemComposable
import com.evolver.eventsapp.people.EventScreenContent
import com.evolver.eventsapp.people.PeopleAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun EventScreen() {
    val colors = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = Color(0xFFFFC6BC))

    Scaffold(
        topBar = { PeopleAppBar(
            isEventScreen = true,
            isPeopleScreen = false,
            title = "Techie",
            colors = colors,
            textColor = Color.Black,
            iconTint = Color.Black)},
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
            EventScreenContent()
        }
    }
}
