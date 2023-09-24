package com.evolver.eventsapp.people

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.evolver.eventsapp.R
import com.evolver.eventsapp.model.Event
import com.evolver.eventsapp.model.EventItem
import com.evolver.eventsapp.model.EventsData
import com.evolver.eventsapp.utils.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleAppBar(title : String = "My people",
                 isPeopleScreen : Boolean = true,
                 isEventScreen : Boolean,
                 colors : TopAppBarColors,
                 textColor : Color = Color(0xFFF9F9FB) ,
                 iconTint : Color = Color(0xFFFFFFFF),
                 onBackPress: () -> Unit = {}) {
    TopAppBar(
        title = {
        Text(
            text = title,
            style = TextStyle(
                fontSize = if (isPeopleScreen) 36.sp else 24.sp,
                lineHeight =  if (isPeopleScreen) 44.47.sp else 28.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontWeight = FontWeight(700),
                color = textColor,
            )
        )
    },
        actions = {

            if (isPeopleScreen){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription = "Add btn",
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp),
                        tint = Color(0xFFFFFFFF)
                    )
                }
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu,
                    contentDescription = "Menu icon",
                    modifier = Modifier
                        .width(26.dp)
                        .height(23.dp),
                    tint = iconTint
                )
            }
        },
        colors = colors,

        navigationIcon = {
            if (isEventScreen){
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Menu icon",
                    modifier = Modifier
                        .width(26.dp)
                        .height(23.dp)
                        .clickable { onBackPress.invoke() },
                    tint = iconTint
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SearchEvent(peopleViewModel: PeopleViewModel = viewModel<PeopleViewModel>()) {
    val searchText by peopleViewModel.searchText.collectAsState()

    OutlinedTextField(
        value = searchText,
        onValueChange = peopleViewModel::onSearchTextChange,
        singleLine = true,
        textStyle =  TextStyle(
            fontSize = 18.sp,
            lineHeight = 23.sp,
            fontFamily = FontFamily(Font(R.font.inter_medium)),
            fontWeight = FontWeight(500),
            color = Color(0xFF3D3D3D),
            letterSpacing = 0.27.sp,
        ),
        placeholder = {
            Text(
                text = "Find event",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 23.31.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF3D3D3D),
                    letterSpacing = 0.27.sp,
                )
            )
        },
        keyboardActions = KeyboardActions.Default,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color(0xFF3D3D3D),

                )},
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFE3E3F2),
                shape = RoundedCornerShape(size = 42.dp)
            )
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = Color(0xFFF9F9FB),
                shape = RoundedCornerShape(size = 42.dp)
            ),
        shape = RoundedCornerShape(42.dp),

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done)
    )
}

@Composable
fun EventItemComposable(event:Event,
    onCommentClick : () -> Unit = {}
) {

    Column(modifier = Modifier
        .fillMaxWidth()
    )
    {

        Box(
            Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFF3F3849),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .fillMaxWidth()
                .height(125.dp)
                .background(
                    color = Color(0xFF3F3849),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )

        ) {
            Row {
                Box(modifier = Modifier.fillMaxHeight(),
                    contentAlignment = Alignment.Center) {
                    Image(painter = painterResource(id = R.drawable.icon_ball),
                        contentDescription = null,
                        modifier = Modifier.size(102.dp),
                        alignment = Alignment.Center)
                }
                Column(modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "${event.title}",
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 36.73.sp,
                            fontFamily = FontFamily(Font(R.font.inter_bold)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                        )
                    )

                    Text(
                        text = "${event.start_date}",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 36.73.sp,
                            fontFamily = FontFamily(Font(R.font.inter_medium)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                        )
                    )


                    Text(
                        text = "${event.start_time}",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Font(R.font.inter_light)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.25.sp,
                        )
                    )

                    Text(
                        text = "${event.location}",
                        style = TextStyle(
                            fontSize = 10.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Font(R.font.inter_light)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFFFFFFFF),
                            letterSpacing = 0.25.sp,
                        )
                    )
                }

                Box(modifier = Modifier
                    .padding(start = 80.dp, top = 50.dp),
                    contentAlignment = Alignment.Center) {
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .background(Color(0xFF3F3849))
                            .size(32.dp)) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "arrow forward",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                }

            }

        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                //TODO
            }
            .border(BorderStroke(1.dp, Color(0xFF000000))),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Text(
                text = "I will join",
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF3F3849),
                    textDecoration = TextDecoration.Underline,
                )
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3F3849))
            .border(
                width = 1.dp,
                color = Color(0xFF000000),
                shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
            )
            .padding(8.dp)){
            Icon(imageVector = Icons.Default.MailOutline,
                contentDescription = null,
                tint = Color.White
                )
            Spacer(modifier = Modifier.width(24.dp))

           Row(modifier = Modifier
               .fillMaxWidth()
               .clickable { onCommentClick.invoke() },
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.SpaceBetween) {
               Text(
                   text = "Leave a comment",
                   style = TextStyle(
                       fontSize = 16.sp,
                       lineHeight = 28.sp,
                       fontFamily = FontFamily(Font(R.font.inter_medium)),
                       fontWeight = FontWeight(500),
                       color = Color.White,
                   )
               )

               Icon(imageVector = Icons.Default.KeyboardArrowRight,
                   contentDescription = null,
                   tint = Color.White
               )
           }

        }
    }
}

@Composable
fun EventScreenContent(eventList: Resource<EventsData>?,
                       gotoCommentScreen : () -> Unit = {}) {

   //val eventList = eventViewModel.getEventsList()
//    val isSearching by peopleViewModel.isSearching.collectAsState()
    Column(modifier = Modifier.padding(24.dp)) {
        SearchEvent()
        Spacer(modifier = Modifier.height(16.dp))
        if (eventList?.data?.data.isNullOrEmpty()) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                itemsIndexed(eventList?.data!!.data) {
                    index, item ->EventItemComposable(eventList.data.data[index]){
                gotoCommentScreen.invoke()
            }
                Spacer(modifier = Modifier.height(24.dp))

                }
            }
        }
    }
}