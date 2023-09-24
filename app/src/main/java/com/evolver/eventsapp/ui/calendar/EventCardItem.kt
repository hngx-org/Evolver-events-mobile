package com.evolver.eventsapp.ui.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.ui.theme.buttonColor


@Composable
fun EventCardItem(
    modifier: Modifier = Modifier,
    eventDescription: String,
    eventLocation: String,
    startTime: String,
    endTime: String,
) {

    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = buttonColor),
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.padding(12.dp),
                content = {
                    Column(
                        modifier = modifier.weight(.1f),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        content = {
                            Text(
                                text = eventDescription,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = eventLocation,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    )

                    Column(
                        modifier = modifier.weight(.1f),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.SpaceEvenly,
                        content = {
                            Text(
                                text = startTime,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = endTime,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    )
                }
            )
        }
    )

}