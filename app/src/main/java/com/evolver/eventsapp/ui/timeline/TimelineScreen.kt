package com.evolver.eventsapp.ui.timeline

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.R

data class Event(
    val title: String,
    val date: String,
    val time: String,
    val location: String,
    val image: Int
)

val events = listOf(
    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),
    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),
    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),
    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),

    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),

    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),

    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),

    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),

    Event(
        "lagos",
        "25th May",
        "London",
        "4 PM",
        R.drawable.ball
    ),


    )

@Composable
fun TimeLineCardItem(event: Event) {
    Column {
        Card(
            modifier = Modifier
                .background(color = Color(0xFFFFC6BC))
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(size = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ball),
                    contentDescription = "image description",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(75.dp)
                        .height(75.dp)
                )
                Column {
                    Text(
                        modifier = Modifier.fillMaxWidth(.75f),
                        text = "Football Game",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "May 20, 2023",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Friday 4 - 6 PM",
                        style = MaterialTheme.typography.titleSmall

                    )
                    Text(
                        text = "Teslim Balogun Stadium",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Go to Event"
                    )
                }
            } // Row
            HorizontalDivider(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }// Card
    } //Column
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TimeLineScreen() {
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }
    var items = remember {
        mutableStateListOf(
            "ComicCon",
            "Lafayette Film Festival"
        )
    }
    val scaffoldState = rememberDrawerState(DrawerValue.Closed)
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Friends", "Everyone")

    val roundedCornerShape = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 16.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )

    val background: @Composable (Modifier) -> Modifier = { modifier ->
        Modifier
            .background(
                color = Color.Blue, // Change the color as needed
                shape = roundedCornerShape
            )
            .then(modifier)
    }
    Scaffold(
        topBar = {},
        bottomBar = {}


    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            SearchBar(modifier = Modifier.fillMaxWidth(),
                query = text,
                onQueryChange = { text = it },
                onSearch = {
                    items.add(text)
                    active = false
                    text = ""
                },
                active = active,
                onActiveChange = {
                    active = it
                },
                placeholder = { Text(text = "Find event") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Find event"
                    )
                },
                trailingIcon = {
                    if (active) {
                        Icon(
                            modifier = Modifier.clickable {
                                if (text.isNotEmpty()) {
                                    text = ""
                                } else {
                                    active = false
                                }

                            },
                            imageVector = Icons.Default.Close, contentDescription = "Close"
                        )
                    }
                }) {
                items.forEach {
                    Row(modifier = Modifier.padding(all = 14.dp)) {
                        Icon(
                            modifier = Modifier.padding(end = 10.dp),
                            imageVector = Icons.Default.History, contentDescription = "History"
                        )
                        Text(text = it)
                    }
                }
            }

            Surface(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 16.dp, bottom = 16.dp)
            ) {
                TabRow(
                    selectedTabIndex = tabIndex,
                    modifier = Modifier
                        .background(
                            color = Color.Blue
                        ).wrapContentSize(),
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(text = { Text(title) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index }
                        )
                    }
                }
            }
            when (tabIndex) {
//                0 -> FriendsScreen()
//                1 -> EveryoneScreen()
            }

            Column {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(events) { event ->
                        TimeLineCardItem(event)
                    }
                }
            }
        }
    }
}