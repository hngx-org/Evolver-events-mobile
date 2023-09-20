package com.evolver.eventsapp.ui.launch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.evolver.eventsapp.R

@Preview(showBackground = true)
@Composable
fun LaunchScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.launch_image),
            contentDescription = "Launch Image"
        )
        Text(
            text = "WetinDeySup",
            style = TextStyle(
                fontSize = 39.sp,
                lineHeight = 51.68.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(700),
                color = Color(0xFF3F3849),
                textAlign = TextAlign.Center,
                letterSpacing = 0.78.sp,
            )
        )
        Text(
            text = "All your events in one place, connect and socialise",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 31.3.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight(500),
                color = Color(0xFF3F3849),
                textAlign = TextAlign.Center,
                letterSpacing = 0.4.sp,
            )
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Get Started")
        }
    }

}