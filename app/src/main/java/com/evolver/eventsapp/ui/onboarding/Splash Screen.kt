package com.evolver.eventsapp.ui.onboarding

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.theme.EventsAppTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
   Column(
       verticalArrangement = Arrangement.Top,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
      Column {

           Box(
               contentAlignment = Alignment.TopCenter,
               modifier = Modifier
                   .background(
                       color = Color.Transparent,
                       shape = RoundedCornerShape(16.dp)
                   )
           ) {
               Box(
                   modifier = Modifier
                       .width(414.dp)
                       .height(60.dp)
                       .background(color = Color(0xFF3F3849))
               ) {

               }
               Image(
                   painter = painterResource(id = R.drawable.background_mask),
                   contentDescription = null,
                   modifier = Modifier
                       .width(414.dp)
                       .height(381.dp)
               )
               Image(
                   painter = painterResource(R.drawable.splash),
                   contentDescription = "Splash Image",
                   modifier = Modifier
                       .width(414.dp)
                       .height(381.dp)

               )


           }
       }
        Spacer(modifier = Modifier.height(40.dp))

     Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)   {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        fontSize = 39.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF3F3849),
                        letterSpacing = 0.78.sp,

                    )) {
                        append("Wetin")
                    }
                    withStyle(style = SpanStyle( fontSize = 39.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF884ED0),
                        letterSpacing = 0.78.sp,)) {
                        append("Dey")
                    }
                    append("Sup")
                },
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 39.sp,
                lineHeight = 51.68.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF3F3849),
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(16.dp))
         // Add the 3-dot page indicator here
         ThreeSmallCircleIndicator()

        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle Get Started button click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(72.32044.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC6BC))


        ) {
            Text(text = "Get Started",
                style = TextStyle(
                    fontSize = 24.sp,
                    lineHeight = 31.09.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF3F3849),
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.36.sp,
                )
                )
        }
       Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun ThreeSmallCircleIndicator() {
    val indicatorCount = 3
    val textList = listOf("All your events in one place, connect and socialize",
        "Discover new events, connect with like-minded people, and have fun together!",
        "Stay up-to-date with the latest happenings, meet interesting individuals, and create lasting memories!")
    var currentIndex by remember { mutableStateOf(0) }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = textList[currentIndex],
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 31.3.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF3F3849),
                textAlign = TextAlign.Center,
                letterSpacing = 0.4.sp,
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Row {
            for (i in 0 until indicatorCount) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(4.dp)
                        .background(
                            color = if (i == currentIndex) Color(0xFF3F3849) else Color.Transparent,
                            shape = CircleShape
                        )
                        .border(width = 2.dp, shape= CircleShape, color = Color(0xFF3F3849))
                )
            }
        }

        LaunchedEffect(Unit) {
            while (true) {
                delay(6000)
                currentIndex = (currentIndex + 1) % indicatorCount
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    EventsAppTheme {
        SplashScreen()
    }
}