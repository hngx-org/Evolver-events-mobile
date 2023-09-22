package com.evolver.eventsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.theme.EventsAppTheme

@Preview(showBackground = true)
@Composable
fun CommentScreen(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
//                    Greeting("Android")
        LazyColumn {
            items(1) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF3F3849))
                        .padding(horizontal = 20.dp, vertical = 30.dp)
                ) {
                    Column {
                        TopBar()
                        Spacer(modifier = Modifier.height(20.dp))
                        ImageBackgroundTopRight()
                    }
                }
                Box(
                    modifier = Modifier
                        .background(Color.White)
                ) {
                    Column {
                        CommentList()
                        CommentList()
                    }

                }
            }

        }

        BottomNavigation()
    }
}







@Composable
fun BottomNavigation() {
    Column(modifier = Modifier
        .fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White) // Set the background color as needed
                .height(56.dp), // Set the height as needed
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Add padding or adjust as needed
                verticalAlignment = Alignment.CenterVertically) {
                Box(modifier=Modifier.padding(1.dp)) {
                    Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = "Back Arrow",
                        modifier = Modifier.size(24.dp),
                    )
                }
                Box(modifier= Modifier
                    .border(.1.dp, Color.Gray, MaterialTheme.shapes.medium)
                    .weight(1f)){
                    BasicTextField(

                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .padding(4.dp)
                            .height(70.dp).fillMaxWidth()
                        ,
                    )
                }

                Box(modifier=Modifier.padding(1.dp)) {
                    Icon(
                        imageVector = Icons.Default.Mic,
                        contentDescription = "Back Arrow",
                        modifier = Modifier.size(24.dp),
                    )
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun CommentList(){
    Box(modifier=Modifier.padding(10.dp)) {
        Row {
            Image(painter = painterResource(id = R.drawable.dp), contentDescription = null, modifier = Modifier.padding(10.dp))

            Box(modifier= Modifier
                .border(2.dp, Color.Gray, MaterialTheme.shapes.medium)
                .padding(10.dp)) {
                Column {
                    Text(text = "Johenxx")
                    Text(text = "I will be there no matter what")
                    Image(painter = painterResource(id = R.drawable.image_ball), contentDescription = null)
                }
            }
        }
    }
}

@Composable
fun TopBar(){
    Box{
        Column(modifier = Modifier
            .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Arrow",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFFFFC6BC)
                )
                Text(text = "11 comments", color = Color(0xFFFFC6BC) )
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color(0xFFFFC6BC)
                )
            }



        }
    }


}

@Composable
fun ImageBackgroundTopRight(
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(
            RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp,
                bottomStart = 20.dp,
                bottomEnd = 20.dp
            )
        )) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFC6BC))
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                        bottomStart = 30.dp,
                        bottomEnd = 30.dp
                    )
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box {
                }
                Image(
                    painter = painterResource(id = R.drawable.bg_rect),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .offset(y = ((-96).dp))
                )
            }


            Box(
                modifier = Modifier
                    .offset(
                        x = (0).dp, // Adjust the horizontal offset as needed
                        y = 0.dp // Adjust the vertical offset as needed
                    )
                    .background(Color.Transparent)
                    .padding(15.dp).fillMaxWidth()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier  = Modifier.fillMaxWidth()) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ball),
                            contentDescription = null,
                            modifier = Modifier
                                .width(80.dp)
                        )
                        Spacer(modifier = Modifier.width(15.dp))
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
                    Text(text = "Share", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 10.dp))
                }

            }
        }
    }
}

@Composable
fun MyCheckbox() {
    var checked  = false

    Checkbox(
        checked = false,
        onCheckedChange = { isChecked ->
            checked = isChecked
        },
        modifier = Modifier.padding(16.dp),
        colors = CheckboxDefaults.colors(
            checkedColor = MaterialTheme.colorScheme.primary,
            uncheckedColor = Color.Gray
        )
    )
}
