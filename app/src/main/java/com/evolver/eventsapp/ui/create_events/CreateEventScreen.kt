package com.evolver.eventsapp.ui.create_events

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.create_events.componets.AdditionalDetail
import com.evolver.eventsapp.ui.create_events.componets.DurationSection
import com.evolver.eventsapp.ui.create_events.componets.LocationScreen
import com.evolver.eventsapp.ui.create_events.componets.SuccessDialog
import com.evolver.eventsapp.ui.theme.EventsAppTheme
import com.evolver.eventsapp.ui.theme.buttonColor
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEvent(
    onBack: () -> Unit,
    state: EventEntity,
    updateState: (EventEntity) -> Unit,
    onGroupsClick: () -> Unit,
    onCreateEvent: () -> Unit,
) {
    var showLocationDialog by remember {
        mutableStateOf(false)
    }

    val keyBoard = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFF3F3849)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {

            ElevatedCard(
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
                content = {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = stringResource(id = R.string.create_event),
                                    style = MaterialTheme.typography.titleLarge
                                )
                            },
                            navigationIcon = {
                                IconButton(
                                    onClick = { onBack() },
                                    content = {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = stringResource(id = R.string.on_back),
                                        )
                                    }
                                )
                            }
                        )
                        Text(
                            text = stringResource(id = R.string.txt_desc),
                            modifier = Modifier.padding(8.dp),
                            style = MaterialTheme.typography.titleSmall
                        )
                        OutlinedTextField(
                            value = state.title,
                            onValueChange = { updateState(state.copy(title = it)) },
                            placeholder = {
                                Text(
                                    text = stringResource(id = R.string.txt_title),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            },
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                            singleLine = false,
                            shape = RoundedCornerShape(9.dp),
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                        )

                        OutlinedTextField(
                            value = state.description,
                            onValueChange = { updateState(state.copy(description = it)) },
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
                            shape = RoundedCornerShape(9.dp),
                            modifier = Modifier
                                .height(122.dp)
                                .padding(8.dp)
                                .fillMaxWidth(),
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
                }
            )

            Column {
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
            }

            Button(
                modifier = Modifier
                    .height(72.32.dp)
                    .fillMaxWidth(),
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
                    Spacer(Modifier.width(4.dp))
                    if (state.isLoading) CircularProgressIndicator()
                }
            )
        }
        AnimatedVisibility(visible = showLocationDialog) {
            LocationScreen(
                state = state,
                updateState = updateState,
                onShowDialog = { showLocationDialog = !showLocationDialog }
            )
        }

        AnimatedVisibility(visible = state.showSuccessDialog) {
            SuccessDialog()
        }

        LaunchedEffect(key1 = Unit, block = {
            delay(5000)
            updateState(state.copy(showSuccessDialog = false))
        })
    }

}


@Preview
@Composable
fun PreviewCreateEvent() {
    EventsAppTheme {
        CreateEvent(
            onBack = { },
            state = EventEntity(),
            updateState = { },
            onGroupsClick = { },
            onCreateEvent = { }
        )
    }
}