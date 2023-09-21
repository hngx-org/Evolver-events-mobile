package com.evolver.eventsapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.evolver.eventsapp.R


val Inter = FontFamily(
    Font(R.font.inter),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 36.73.sp,
        letterSpacing = 0.sp,
        color = Color(0xFF3F3849)
    ),

    titleSmall = TextStyle(
        fontFamily = Inter,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFF000000)
    ),

    bodySmall = TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp,
        fontFamily = Inter,
        fontWeight = FontWeight(500),
        color = Color(0xFF33313E),
    )

    /*
    labelSmall = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Medium,
    fontSize = 11.sp,
    lineHeight = 16.sp,
    letterSpacing = 0.5.sp
    )
    */
)
