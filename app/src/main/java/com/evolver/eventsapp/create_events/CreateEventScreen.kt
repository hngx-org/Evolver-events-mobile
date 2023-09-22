package com.evolver.eventsapp.create_events

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.create_events.componets.AdditionalDetail
import com.evolver.eventsapp.create_events.componets.DurationSection
import com.evolver.eventsapp.create_events.componets.EventTopBar
import com.evolver.eventsapp.create_events.componets.LocationScreen
import com.evolver.eventsapp.ui.theme.EventsAppTheme
import com.evolver.eventsapp.ui.theme.buttonColor


@Composable
fun CreateEvent(
    onBack: () -> Unit,
    state: EventState,
    updateState: (EventState) -> Unit,
    onGroupsClick: () -> Unit,
    onCreateEvent: () -> Unit,
) {
    var showLocationDialog by remember {
        mutableStateOf(false)
    }

    val keyBoard = LocalSoftwareKeyboardController.current

    Scaffold(
        modifier = Modifier,
        topBar = { EventTopBar(onBack = onBack) },
        content = { scaffoldPadding ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(12.dp)
                    .background(MaterialTheme.colorScheme.primary),
                verticalArrangement = Arrangement.SpaceEvenly,
                content = {
                    ElevatedCard(
                        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
                        content = {
                            Column(
                                modifier = Modifier.padding(scaffoldPadding),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                content = {
                                    Text(
                                        text = stringResource(id = R.string.txt_desc),
                                        modifier = Modifier.padding(8.dp),
                                        style = MaterialTheme.typography.titleSmall
                                    )
                                    OutlinedTextField(
                                        value = state.eventDescription,
                                        onValueChange = { updateState(state.copy(eventDescription = it)) },
                                        placeholder = {
                                            Text(
                                                text = stringResource(id = R.string.edit_desc),
                                                style = MaterialTheme.typography.bodyMedium
                                            )
                                        },
                                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                                        keyboardActions = KeyboardActions(
                                            onDone = { keyBoard?.hide() }),
                                        singleLine = false,
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .fillMaxWidth()
                                    )
                                    DurationSection(
                                        durationTitle = stringResource(id = R.string.starts),
                                        durationDate = state.startDate,
                                        onDateChanged = { updateState(state.copy(startDate = it)) },
                                        durationTime = state.startTime,
                                        onTimeChanged = { updateState(state.copy(startTime = it)) }
                                    )
                                    DurationSection(
                                        durationTitle = stringResource(id = R.string.ends),
                                        durationDate = state.endDate,
                                        onDateChanged = { updateState(state.copy(endDate = it)) },
                                        durationTime = state.endTime,
                                        onTimeChanged = { updateState(state.copy(endTime = it)) },
                                    )
                                }
                            )
                        }
                    )

                    AdditionalDetail(
                        icon = Icons.Default.LocationOn,
                        title = stringResource(id = R.string.location),
                        onDetailClick = {
                            showLocationDialog = !showLocationDialog
                        }
                    )
                    AdditionalDetail(
                        icon = Icons.Default.Groups,
                        title = stringResource(id = R.string.sel_groups),
                        onDetailClick = onGroupsClick
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonColor,
                            contentColor = MaterialTheme.colorScheme.onSurface
                        ),
                        onClick = { onCreateEvent() },
                        content = {
                            Text(
                                text = stringResource(id = R.string.create_event),
                                style = MaterialTheme.typography.titleLarge,
                            )
                        }
                    )
                }
            )
            AnimatedVisibility(visible = showLocationDialog) {
                LocationScreen(
                    state = state,
                    updateState = updateState,
                    onShowDialog = { showLocationDialog = !showLocationDialog }
                )
            }
        }
    )
}


@Preview
@Composable
fun PreviewCreateEvent() {
    EventsAppTheme {
        CreateEvent(
            onBack = { },
            state = EventState(),
            updateState = { },
            onGroupsClick = { },
            onCreateEvent = { }
        )
    }
}