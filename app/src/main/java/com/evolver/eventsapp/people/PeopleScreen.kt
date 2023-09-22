package com.evolver.eventsapp.people

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.evolver.eventsapp.R
import com.evolver.eventsapp.TimelineGraph
import com.evolver.eventsapp.model.EventCardItem
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun PeopleScreen(navController: NavController = rememberNavController()) {
    val eventCardItemList = listOf(
        EventCardItem(
            eventPeopleName = "YBNL",
            eventCount = 5,
            eventIcon = painterResource(id = R.drawable.groupie)
        ),
        EventCardItem(
            eventPeopleName = "ODG",
            eventCount = 4,
            eventIcon = painterResource(id = R.drawable.groupie)
        ),
        EventCardItem(
            eventPeopleName = "Evolver",
            eventCount = 5,
            eventIcon = painterResource(id = R.drawable.groupie)
        ),
        EventCardItem(
            eventPeopleName = "Death Squad",
            eventCount = 4,
            eventIcon = painterResource(id = R.drawable.groupie)
        ),
        EventCardItem(
            eventPeopleName = "J Squad",
            eventCount = 2,
            eventIcon = painterResource(id = R.drawable.groupie)
        )

    )

    //TODO : Change the random colors
    val randColors = listOf(
        Color(0xFAC190FF),
        Color(0xFF03A9F4),
        Color(0xFFFFE0C4),
        Color(0xFFC4FFEA)
    )

    val randomColors = remember {
        eventCardItemList.indices.map { Random.nextInt(0, randColors.size) }
    }

    val color = TopAppBarDefaults.mediumTopAppBarColors(
        containerColor = Color(0xFF3F3849))
    Scaffold(
        topBar = {
            PeopleAppBar(isPeopleScreen = true,
            isEventScreen = false, title = "My People", colors = color)}
    ) {
        Surface(modifier = Modifier.padding(it)) {
            Box(modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .background(Color(0xFF3F3849))
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)))

            val state = rememberLazyGridState()
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    itemsIndexed(eventCardItemList){i,eventItem ->
                        val randomColorIndex = randomColors[i]
                        val randomColor = randColors[randomColorIndex]
                       Box( modifier =
                       Modifier
                           .padding(12.dp),
                           contentAlignment = Alignment.Center) {
                           PeopleEventCard(color = randomColor, eventCardItem = eventItem){
                               //TODO: navigate to event screen
                               navController.navigate("events")
                           }

                       }
                    }
                },
                modifier = Modifier.padding(horizontal = 24.dp),
                state = state)


        }

    }
}

@Composable
fun PeopleEventCard(
    eventCardItem: EventCardItem ,
    color: Color,
    eventIcon: ImageVector = Icons.Default.Call,
    onGroupClick : () -> Unit = {}) {
Column(modifier = Modifier
    .width(176.dp)
    .height(180.dp)
    .background(
        color = color,
        shape = RoundedCornerShape(size = 20.dp)
    )
    .clickable {
        onGroupClick.invoke()
    }) {

    Spacer(modifier = Modifier.height(24.dp))
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)) {

            Text(
                text = eventCardItem.eventPeopleName,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF33313E),
                ),
                overflow = TextOverflow.Ellipsis
            )

            Box(contentAlignment = Alignment.Center){
                Icon(imageVector = Icons.Default.Call,
                    contentDescription = "Event Icon",
                    modifier = Modifier.size(22.dp))
            }

        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "${eventCardItem.eventCount} Events",
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 19.43.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF3F3849),
            ),
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Icon(painter = eventCardItem.eventIcon,
            contentDescription = "event image",
            modifier = Modifier
                .padding(horizontal = 20.dp,
                    vertical = 10.dp)
                .size(150.dp)
                .background(Color.Transparent))

    }

}


}
data class RandomColorItem(val color: Color)

