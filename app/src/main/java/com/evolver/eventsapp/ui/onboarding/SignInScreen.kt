package com.evolver.eventsapp.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun SignInScreen() {
    Column(  verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(
                color = Color(0xFF3F3849)
            )
            .fillMaxSize()
    )
    {
        Spacer(modifier = Modifier.size(16.dp))
        Row( modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_nav),
                modifier = Modifier.clickable {  },
                contentDescription = "back nav",
                tint = Color.White
            )
        }
        Column(

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


          Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center)  {
                Text(
                    "Welcome on Board!",
                    style = TextStyle(
                        fontSize = 28.sp,
                        lineHeight = 39.77.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Text(
                    "We're glad you're here.",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.72.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF8C8896),
                        letterSpacing = 0.4.sp,
                    )
                )
            }

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(modifier = Modifier
                    .padding(0.00041.dp)
                    .width(281.19955.dp)
                    .height(227.95779.dp),
                    painter = painterResource(R.drawable.illustration_17),
                    contentDescription = "Your Image"
                )
            }
Spacer(modifier = Modifier.size(height = 70.dp, width = 0.dp))
            Text("Sign In or Create an Account",style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 23.31.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.45.sp,
            ))

            Button(
                onClick = { /* Handle continue with Google */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFFFFF)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(362.dp)
                    .height(78.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.google_logo),
                        contentDescription = "google logo",
                        tint = Color(0xFF000000)
                    )
                    Spacer(modifier = Modifier.size(width = 4.dp, height = 0.dp))
                    Text(
                        "Continue with Google",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 23.31.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                            letterSpacing = 0.45.sp,
                        )
                    )
                }
            }

            Button(
                onClick = { /* Handle continue with Twitter */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFC6BC)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(362.dp)
                    .height(78.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.twitter_logo),
                        contentDescription = "twitter logo",
                        tint = Color(0xFF000000)
                    )
                    Spacer(modifier = Modifier.size(width = 4.dp, height = 0.dp))
                    Text(
                        "Continue with Twitter",
                                style = TextStyle(
                                fontSize = 18.sp,
                        lineHeight = 23.31.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        letterSpacing = 0.45.sp,
                    )
                    )
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun SigninScreenPreview() {
    EventsAppTheme {
        SignInScreen()
    }
}