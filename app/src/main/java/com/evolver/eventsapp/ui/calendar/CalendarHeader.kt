package com.evolver.eventsapp.ui.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.create_events.util.dateToString
import com.evolver.eventsapp.ui.theme.EventsAppTheme
import java.time.LocalDate

/**
 * <   March 2023  >
 */

@Composable
fun CalendarHeader(
    modifier: Modifier = Modifier,
    eventDate: LocalDate,
    onPreviousMonthClick: () -> Unit,
    onNextMonthClick: () -> Unit,
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            IconButton(
                onClick = onPreviousMonthClick,
                content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = stringResource(id = R.string.on_back)
                    )
                }
            )
            Spacer(modifier = modifier.width(10.dp))

            Text(
                text = eventDate.dateToString("MMMM yyyy"),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = modifier.width(10.dp))

            IconButton(
                onClick = onNextMonthClick,
                content = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = stringResource(id = R.string.on_next)
                    )
                }
            )

        }
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewCalendarHeader() {
    EventsAppTheme {
        CalendarHeader(
            eventDate = LocalDate.now(),
            onPreviousMonthClick = { },
            onNextMonthClick = { }
        )
    }
}