package com.evolver.eventsapp.ui.create_events.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.theme.buttonColor

@Composable
fun SuccessDialog(
    modifier: Modifier = Modifier,
    onShowDialog: () -> Unit = {},
) {

    Dialog(onDismissRequest = { onShowDialog() }) {

        ElevatedCard(
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(8.dp),
            content = {
                Column(
                    modifier = modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    content = {

                        Image(
                            imageVector = Icons.Default.ThumbUp,
                            colorFilter = ColorFilter.tint(buttonColor),
                            contentDescription = stringResource(id = R.string.success)
                        )
                        Text(
                            text = stringResource(id = R.string.success),
                            style = MaterialTheme.typography.titleMedium
                        )


                    }
                )
            }
        )
    }
}