package com.evolver.eventsapp.ui.create_events.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.create_events.util.dateToString
import com.evolver.eventsapp.ui.create_events.util.longToLocalDate
import com.evolver.eventsapp.ui.create_events.util.timeToString
import com.evolver.eventsapp.ui.theme.EventsAppTheme
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun DurationSection(
    durationTitle: String,
    modifier: Modifier = Modifier,
    durationDate: LocalDate,
    onDateChanged: (LocalDate) -> Unit,
    durationTime: LocalTime,
    onTimeChanged: (LocalTime) -> Unit
) {
    Column(
        modifier = modifier.padding(12.dp),
        horizontalAlignment = Alignment.Start,
        content = {
            Text(text = durationTitle, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = modifier.height(5.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    DateSelector(
                        modifier = modifier.weight(.1f),
                        eventDate = durationDate,
                        onDateChanged = onDateChanged
                    )
                    TimeSelector(
                        modifier = modifier.weight(.1f),
                        eventTime = durationTime,
                        onTimeChanged = onTimeChanged
                    )
                }
            )
        }
    )
}

//Date dd MMM
@Composable
private fun DateSelector(
    modifier: Modifier = Modifier,
    eventDate: LocalDate,
    onDateChanged: (LocalDate) -> Unit,
) {

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            Text(
                text = stringResource(id = R.string.date),
                style = MaterialTheme.typography.titleMedium
            )
            DurationBox(
                onBoxClick = { showDatePicker = true },
                icon = Icons.Default.DateRange,
                durationTxt = eventDate.dateToString("dd MMM")
            )
            if (showDatePicker) {
                CustomDatePicker(
                    modifier = modifier.padding(15.dp),
                    selectedDate = eventDate,
                    onDateSelected = onDateChanged,
                    onDismiss = { showDatePicker = false }
                )
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomDatePicker(
    modifier: Modifier = Modifier,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    onDismiss: () -> Unit,
) {
    //Only future dates
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis >= System.currentTimeMillis()
        }
    })

    val date = remember {
        mutableStateOf(selectedDate)
    }

    DatePickerDialog(
        modifier = modifier.padding(15.dp),
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(
                onClick = {
                    date.value =
                        datePickerState.selectedDateMillis?.longToLocalDate() ?: LocalDate.now()
                    onDateSelected(date.value)
                    onDismiss()
                },
                content = {
                    Text(text = stringResource(id = R.string.ok))
                }
            )
        },
        dismissButton = {
            OutlinedButton(
                onClick = { onDismiss() },
                content = {
                    Text(text = stringResource(id = R.string.cancel))
                })
        },
        content = {
            DatePicker(
                state = datePickerState
            )
        }
    )
}


//Time HH:MM
@Composable
private fun TimeSelector(
    modifier: Modifier = Modifier,
    eventTime: LocalTime,
    onTimeChanged: (LocalTime) -> Unit,
) {
    var showTimePicker by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            Text(
                text = stringResource(id = R.string.time),
                style = MaterialTheme.typography.titleMedium
            )
            DurationBox(
                onBoxClick = { showTimePicker = true },
                icon = Icons.Default.AccessTime,
                durationTxt = eventTime.timeToString()
            )

            if (showTimePicker) {
                CustomTimePicker(
                    eventTime = eventTime,
                    onTimeSelected = onTimeChanged,
                    onDismiss = { showTimePicker = false },
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTimePicker(
    modifier: Modifier = Modifier,
    eventTime: LocalTime,
    onTimeSelected: (LocalTime) -> Unit,
    onDismiss: () -> Unit,
) {

    val selectedTime = remember { mutableStateOf(eventTime) }
    val timePickerState = rememberTimePickerState(
        initialHour = selectedTime.value.hour,
        initialMinute = selectedTime.value.minute,
    )

    AlertDialog(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(size = 12.dp)
            ),
        onDismissRequest = { onDismiss() },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    TimePicker(state = timePickerState, modifier = modifier.padding(12.dp))
                    Row(
                        modifier = modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        content = {
                            OutlinedButton(
                                onClick = {
                                    onDismiss()
                                },
                                content = {
                                    Text(text = stringResource(id = R.string.cancel))
                                }
                            )
                            Spacer(modifier = Modifier.width(7.dp))

                            Button(
                                onClick = {
                                    selectedTime.value =
                                        LocalTime.of(timePickerState.hour, timePickerState.minute)
                                    onTimeSelected(selectedTime.value)
                                    onDismiss()
                                },
                                content = {
                                    Text(text = stringResource(id = R.string.ok))
                                }
                            )
                        }
                    )
                }
            )
        }
    )
}

@Composable
private fun DurationBox(
    modifier: Modifier = Modifier,
    onBoxClick: () -> Unit,
    icon: ImageVector,
    durationTxt: String,
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onBoxClick() },
        content = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                content = {
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(id = R.string.event_time)
                    )

                    Text(text = durationTxt)
                }
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewDateSelection() {
    EventsAppTheme {
        DurationSection(
            durationTitle = "Starts",
            durationDate = LocalDate.now(),
            onDateChanged = { },
            durationTime = LocalTime.now(),
            onTimeChanged = { }
        )
    }

}