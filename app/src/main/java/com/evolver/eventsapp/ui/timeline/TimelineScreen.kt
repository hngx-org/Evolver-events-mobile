package com.evolver.eventsapp.ui.timeline

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.theme.EventsAppTheme


@Composable
fun EventCardItem() {
    Column {
        Card(
            modifier = Modifier
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
                        style = MaterialTheme.typography.titleLarge,
                        fontFamily = FontFamily(
                            Font(R.font.inter_bold)
                        ),
                        fontWeight = FontWeight(700)
                    )
                    Text(
                        text = "May 20, 2023",
                        style = MaterialTheme.typography.titleSmall,

                        )
                    Text(
                        text = "Friday 4 - 6 PM",
                        style = MaterialTheme.typography.titleMedium

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
            }
        }// Card
    } //Column
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeLineScreen(
    onAddEventClick: () -> Unit,
) {
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }
    val items = remember {
        mutableStateListOf(
            "ComicCon",
            "Lafayette Film Festival"
        )
    }
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Friends", "Everyone")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Timeline", color = Color.White) },
                actions = {
                    Button(
                        onClick = onAddEventClick,
                        content = {
                            Text(
                                text = stringResource(id = R.string.create_event),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFF3F3849))
            )
        },
        content = { scaffoldPadding ->

            Surface() {
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth()
                        .background(Color(0xFF3F3849))
                        .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                )


                Column(
                    modifier = Modifier
                        .padding(scaffoldPadding)
                        .padding(16.dp)
                ) {
                    SearchBar(
                        modifier = Modifier.fillMaxWidth(),
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
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
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
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    ) {
                        items.forEach {
                            Row(modifier = Modifier.padding(all = 14.dp)) {
                                Icon(
                                    modifier = Modifier.padding(end = 10.dp),
                                    imageVector = Icons.Default.History,
                                    contentDescription = "History"
                                )
                                Text(text = it)
                            }
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier
                            .width(250.dp)
                            .padding(top = 16.dp, bottom = 16.dp),
                    ) {
                        TabRow(
                            selectedTabIndex = tabIndex,
                            modifier = Modifier
                                .background(
                                    color = Color.Blue
                                ),
                        ) {
                            tabs.forEachIndexed { index, title ->
                                Tab(text = { Text(title) },
                                    selected = tabIndex == index,
                                    onClick = { tabIndex = index }
                                )
                            }
                        }
                    }

                    //            when (tabIndex) {
                    //                0 -> FriendsScreen()
                    //                1 -> EveryoneScreen()
                    //            }

                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(events) { event ->
                            EventCardItem()
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTimeLineScreen() {
    EventsAppTheme {
        TimeLineScreen(onAddEventClick = { })
    }
}