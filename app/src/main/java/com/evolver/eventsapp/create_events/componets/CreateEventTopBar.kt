package com.evolver.eventsapp.create_events.componets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.theme.EventsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventTopBar(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { Text(text = stringResource(id = R.string.create_event), style = MaterialTheme.typography.titleLarge) },
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

}

@Preview
@Composable
private fun PrevEventTopBar() {
    EventsAppTheme {
        EventTopBar(onBack = { })
    }
}