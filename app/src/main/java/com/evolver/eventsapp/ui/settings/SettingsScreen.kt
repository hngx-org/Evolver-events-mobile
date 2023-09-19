package com.evolver.eventsapp.ui.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.theme.EventsAppTheme

@Composable
fun SettingsScreen() {
    Column {
        Column(modifier= Modifier
            .height(603.dp)
            .background(color = Color(0xFF3F3849))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Settings",
                    style = TextStyle(
                        fontSize = 36.sp,
                        lineHeight = 44.47.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFF9F9FB),
                    ),
                    modifier = Modifier.padding(start = 8.dp)
                )
                IconButton(colors = IconButtonDefaults.iconButtonColors() ,
                    onClick = { /*TODO*/ }){
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Menu Icon",
                        modifier = Modifier.size(24.dp),
                        tint = Color(0xFFF9F9FB)
                    )
                }
            }
            ProfileSection()
            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())){
                ItemsSection()
                CutOutSection()
            }
        }

        LogoutButton()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(
                color = Color(0xFF3F3849),
                shape = RoundedCornerShape(10.dp)
            )
    ) {
        Row(modifier =
        Modifier
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { }
        )  {
            ListItem(modifier = Modifier
                .height(82.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(10.dp)
                ),
                leadingContent = {
                    Image(
                        painter = painterResource(R.drawable.person_24),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                },
                headlineText = {
                    Text(
                        text = "User Name",
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 22.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF33313E),
                        )
                    )
                },
                supportingText = { Text(
                    text = "user@example.com",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF84838B),
                        letterSpacing = 0.3.sp,
                    )
                ) },
                trailingContent = {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right),
                        contentDescription = "Arrow Right Icon"
                    )
                },
                colors = ListItemDefaults.colors(containerColor = Color.Transparent)
            )
        }
    }
}

@Composable
fun ItemsSection() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp)

    ) {
        Column{
            Item("Notifications", R.drawable.notifications_none_24)
            Item("Privacy", R.drawable.security)
            Item("Appearance", R.drawable.appearance)
            Item("Language and Region", R.drawable.language)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Item(text: String, icon: Int) {
    val backgroundColor = when (text) {
        "Notifications" -> Color(0xFFFFC6BC)
        "Privacy" -> Color(0xFFD2F5FE)
        "Appearance" -> Color(0xFFFFE0C4)
        "Language and Region" -> Color(0xFFFFC6BC)
        "Help and Support" -> Color(0xFFD2F5FE)
        "About" -> Color(0xFFFFE0C4)
        else -> Color.White
    }

    ListItem(
        modifier = Modifier
            .background(color = backgroundColor)
            .padding(4.dp)
            .clickable { },
        leadingContent = {
            Image(
                painter = painterResource(icon),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )
        },
        headlineText = {
            Text(
                text= text,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF33313E),
                )
            )
        },
        trailingContent = {
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),
                contentDescription = "Arrow Right Icon"
            )
        },
        colors = ListItemDefaults.colors(containerColor = backgroundColor)
    )
}

@Composable
fun CutOutSection() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp)

    )  {
        Column {
            Item("Help and Support", R.drawable.help)
            Item("About", R.drawable.outline)
        }
    }
}

@Composable
fun LogoutButton() {
    Row(
    ) {
        Button(onClick = { /* Handle logout */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color(0xFFEA3131),
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.logout_left),
                    contentDescription = "Logout Icon"
                )
                Spacer(modifier = Modifier.size(width = 4.dp, height = 0.dp))
                Text(
                    text= "Logout"
                    ,
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFEA3131),
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventsAppTheme {
        SettingsScreen()
    }
}