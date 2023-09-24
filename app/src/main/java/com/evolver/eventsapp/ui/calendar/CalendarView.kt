package com.evolver.eventsapp.ui.calendar

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.ui.theme.EventsAppTheme
import com.evolver.eventsapp.ui.theme.buttonColor
import kotlinx.coroutines.launch
import java.time.LocalDate



private const val CALENDAR_ROWS = 5
private const val CALENDAR_COLUMNS = 7


@Composable
fun CalendarView(
    modifier: Modifier = Modifier,
    onDayClick: (Int) -> Unit,
    eventDate: LocalDate,
    onPreviousMonthClick: () -> Unit,
    onNextMonthClick: () -> Unit,
) {
    var canvasSize by remember {
        mutableStateOf(Size.Zero)
    }

    var clickAnimationOffset by remember {
        mutableStateOf(Offset.Zero)
    }

    var animationRadius by remember {
        mutableStateOf(0f)
    }

    val scope = rememberCoroutineScope()

    val daysInMonth = remember {
        mutableStateOf(eventDate.lengthOfMonth())
    }
    // Calculate the day of the week for the first day of the month (1-based, where 1 is Sunday)
    val firstDayOfWeek = eventDate.withDayOfMonth(1).dayOfWeek.value

    Column(
        modifier = modifier.background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            CalendarHeader(
                eventDate = eventDate,
                onPreviousMonthClick = onPreviousMonthClick,
                onNextMonthClick = onNextMonthClick
            )

            // Display the day names (Sun to Sat) at the top
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                content = {
                    val dayNames = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
                    for (dayName in dayNames) {
                        Text(
                            text = dayName,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            )

            // Canvas for the calendar grid
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .background(color = Color.White)
                    .pointerInput(true) {
                        detectTapGestures { offset ->
                            val xSteps = canvasSize.width / CALENDAR_COLUMNS
                            val ySteps = canvasSize.height / CALENDAR_ROWS

                            val x = offset.x
                            val y = offset.y

                            val column = ((x / xSteps).coerceIn(0f, CALENDAR_COLUMNS.toFloat() - 1) + 1).toInt()
                            val row = ((y / ySteps).coerceIn(0f, CALENDAR_ROWS.toFloat() - 1) + 1).toInt()
                            val day = row * CALENDAR_COLUMNS + column - firstDayOfWeek + 2

                            if (day in 1..daysInMonth.value) {
                                onDayClick(day)
                                clickAnimationOffset = offset
                                scope.launch {
                                    animate(0f, 225f, animationSpec = tween(300)) { value, _ ->
                                        animationRadius = value
                                    }
                                }
                            }
                        }
                    },
                onDraw = {
                    val canvasHeight = size.height
                    val canvasWidth = size.width
                    canvasSize = Size(canvasWidth, canvasHeight)

                    val ySteps = canvasHeight / CALENDAR_ROWS
                    val xSteps = canvasWidth / CALENDAR_COLUMNS

                    var day = 1 // Start from the first day of the month


                    val column2 = (clickAnimationOffset.x / canvasSize.width * CALENDAR_COLUMNS).toInt() + 1
                    val row2 = (clickAnimationOffset.y / canvasSize.height * CALENDAR_ROWS).toInt() + 1

                    val path = Path().apply {
                        moveTo((column2-1)*xSteps,(row2-1)*ySteps)
                        lineTo(column2*xSteps,(row2-1)*ySteps)
                        lineTo(column2*xSteps,row2*ySteps)
                        lineTo((column2-1)*xSteps,row2*ySteps)
                        close()
                    }

                    clipPath(path){
                        drawCircle(
                            brush = Brush.radialGradient(
                                listOf(buttonColor.copy(0.8f), buttonColor.copy(0.2f)),
                                center = clickAnimationOffset,
                                radius = animationRadius + 0.1f
                            ),
                            radius = animationRadius + 0.1f,
                            center = clickAnimationOffset
                        )
                    }

                    for (row in 1..CALENDAR_ROWS) {
                        for (column in 1..CALENDAR_COLUMNS) {

                            // Draw the day number
                            if (day <= daysInMonth.value) {
                                val column1 = (firstDayOfWeek + day - 2) % CALENDAR_COLUMNS
                                val row1 = (firstDayOfWeek + day - 2) / CALENDAR_COLUMNS

                                val xText = (column1 + 1) * xSteps - xSteps / 2
                                val yText = (row1 + 1) * ySteps - ySteps / 2

                                val textHeight = 17.dp.toPx()
                                drawContext.canvas.nativeCanvas.drawText(
                                    day.toString(),
                                    xText,
                                    yText + textHeight / 2, // Center vertically
                                    android.graphics.Paint().apply {
                                        textSize = textHeight
                                        color = Color.Black.toArgb()
                                        isFakeBoldText = true
                                    }
                                )

                                day++
                            }
                        }
                    }
                }
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewCalendar() {
    EventsAppTheme {

        CalendarView(
            onDayClick = { },
            eventDate = LocalDate.now(),
            onPreviousMonthClick = { },
            onNextMonthClick = { },
        )

    }
}