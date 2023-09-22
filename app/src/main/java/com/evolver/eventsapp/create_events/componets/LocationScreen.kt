package com.evolver.eventsapp.create_events.componets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.evolver.eventsapp.R
import com.evolver.eventsapp.create_events.EventState


@Composable
fun LocationScreen(
    state: EventState,
    updateState: (EventState) -> Unit,
    onShowDialog: () -> Unit
) {


    Dialog(onDismissRequest = { onShowDialog() }) {

        ElevatedCard(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(8.dp),
            content = {
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {
                        Text(
                            text = stringResource(id = R.string.add_location),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        OutlinedTextField(
                            value = state.eventLocation,
                            onValueChange = {
                                updateState(state.copy(eventLocation = it))
                            },
                            singleLine = true,
                            label = { Text(text = stringResource(id = R.string.add_location)) }
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(7.dp),
                            content = {
                                OutlinedButton(
                                    onClick = { onShowDialog() },
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(text = stringResource(id = R.string.cancel))
                                }


                                Button(
                                    onClick = {
                                        onShowDialog()
                                    },
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text(text = stringResource(id = R.string.ok))
                                }
                            }
                        )
                    }
                )
            }
        )
    }
}