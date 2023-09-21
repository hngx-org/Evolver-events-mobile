package com.evolver.eventsapp.ui.theme.comment

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evolver.eventsapp.R

@Composable
@Preview(showBackground = true)
fun SettingsScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        SettingsCard()
        ChatBox()
    }
}

@Composable
fun SettingsCard(){
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color(0xFF3F3849)
    ) {
        Column (
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        ){
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                IconButton(
                    onClick = {
//                        val msg = chatBoxValue.text
//                        if (msg.isBlank()) return@IconButton
//                        //  onSendChatClickListener(chatBoxValue.text)
//                        chatBoxValue = TextFieldValue("")
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "image",
                        contentScale = ContentScale.Fit,
                    )
                }
                Text(
                    text = "11 Comments",
                    fontSize = 24.sp,
                    color = Color(0xFFFFC6BC),
                    fontWeight = FontWeight(700),
                )
                IconButton(
                    onClick = {
                    },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menur),
                        contentDescription = "image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .height(19.22.dp)
                            .width(23.4.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Surface(
                color = Color(0xFFFFC6BC),
                shape = RoundedCornerShape(16),
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Column (
                ){
                    Row (
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.settings_image),
                            contentDescription = "image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(70.dp)
                                .width(70.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(10.dp)
                        )
                        Column {
                            Text(
                                text = "Football game",
                                fontSize = 24.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight(700),
                            )
                            Text(
                                text = "May 20, 2023",
                                fontSize = 26.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight(700),
                            )
                            Text(
                                text = "Friday 4 - 6 PM",
                                fontSize = 14.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight(700),
                            )
                            Text(
                                text = "Teslim Balogun Stadium",
                                fontSize = 16.sp,
                                color = Color(0xFF000000),
                                fontWeight = FontWeight(700),
                            )
                        }
                    }
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 3.dp, end = 3.dp)
                            .height(30.dp),
                        color = Color(0xFF3F3849)
                    ){
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Box(modifier = Modifier
                                .height(22.dp)
                                .width(22.dp)
                                .border(
                                    shape = RoundedCornerShape(3),
                                    width = 2.dp,
                                    color = Color.White
                                ),
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Check Box to Invite to Techies",
                                fontSize = 16.sp,
                                color = Color.White,
                                fontWeight = FontWeight(700),
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Share",
                        fontSize = 16.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight(700),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            commentScreen()
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxScope.ChatBox(){
    var chatBoxValue by remember { mutableStateOf(TextFieldValue("")) }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .align(Alignment.BottomEnd),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = {
                val msg = chatBoxValue.text
                if (msg.isBlank()) return@IconButton
                //  onSendChatClickListener(chatBoxValue.text)
                chatBoxValue = TextFieldValue("")
            },
        ) {
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "image",
                contentScale = ContentScale.Fit
            )
        }
        TextField(
            value = chatBoxValue,
            onValueChange = { newText ->
                chatBoxValue = newText
            },
            modifier = Modifier
                .border(
                    width = 0.5.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(40.dp),
                    ),
            shape = RoundedCornerShape(40.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent
            ),
            placeholder = {
                Text(text = "Type something")
            }
        )
        IconButton(
            onClick = {
                val msg = chatBoxValue.text
                if (msg.isBlank()) return@IconButton
                //  onSendChatClickListener(chatBoxValue.text)
                chatBoxValue = TextFieldValue("")
            },
        ) {
            Image(
                painter = painterResource(id = R.drawable.vn),
                contentDescription = "image",
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun commentScreen(){
    LazyColumn{
    }
}

@Composable
fun ChatContainer(){
    Row {
    }
}
