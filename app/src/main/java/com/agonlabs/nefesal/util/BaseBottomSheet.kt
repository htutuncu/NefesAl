package com.agonlabs.nefesal.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agonlabs.nefesal.ui.theme.loraFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseBottomSheet(
    primaryButtonText: String,
    secondaryButtonText: String,
    headerText: String,
    onDismiss: () -> Unit,
    onPrimaryAction: () -> Unit,
    onSecondaryAction: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info",
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = headerText,
                fontFamily = loraFamily,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(onClick = onPrimaryAction, modifier = Modifier.weight(1f)) {
                    Text(primaryButtonText)
                }
                OutlinedButton(onClick = onSecondaryAction, modifier = Modifier.weight(1f)) {
                    Text(secondaryButtonText)
                }
            }
        }
    }
}

@Preview
@Composable
fun Greeting() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info",
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "headerText",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(onClick = {}, modifier = Modifier.weight(1f)) {
                    Text("primaryButtonText")
                }
                OutlinedButton(onClick = {}, modifier = Modifier.weight(1f)) {
                    Text("secondaryButtonText")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}