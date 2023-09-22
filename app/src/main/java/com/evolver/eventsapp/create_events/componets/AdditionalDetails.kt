package com.evolver.eventsapp.create_events.componets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.evolver.eventsapp.R
import com.evolver.eventsapp.ui.theme.buttonColor

@Composable
fun AdditionalDetail(
    icon: ImageVector,
    title: String,
    onDetailClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            Icon(
                imageVector = icon,
                contentDescription = stringResource(id = R.string.txt_desc),
                tint = buttonColor
            )
            TextButton(
                onClick = { onDetailClick() },
                content = { Text(text = title, color = MaterialTheme.colorScheme.onPrimary) }
            )
        }
    )
}