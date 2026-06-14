package com.example.android_portfolio.screens.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_portfolio.components.shared.FullWidthIconButton
import com.example.android_portfolio.components.shared.InfoDisplayCard
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimePickerScreen() {

    /* ── State ── */
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = System.currentTimeMillis()
    )

    val timePickerState = rememberTimePickerState(
        initialHour = 5,
        initialMinute = 30,
        is24Hour = false
    )

    /* ── Formatted display strings ── */
    val formattedDate = datePickerState.selectedDateMillis?.let { millis ->
        SimpleDateFormat("EEE, MMM dd yyyy", Locale.getDefault()).format(Date(millis))
    } ?: "No date selected"

    val hour   = timePickerState.hour
    val minute = timePickerState.minute
    val amPm   = if (hour < 12) "AM" else "PM"
    val hour12 = when {
        hour == 0  -> 12
        hour > 12  -> hour - 12
        else       -> hour
    }
    val formattedTime = "%02d:%02d %s".format(hour12, minute, amPm)

    /* ── UI ── */
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Alarm Scheduler",
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
        ) {

            // ── Selected date & time display ──
            InfoDisplayCard(
                label = "Scheduled Alarm",
                subtitle = formattedDate,
                value = formattedTime,
                valueFontSize = 36.sp
            )

            // ── Date Picker button ──
            FullWidthIconButton(
                text = "Pick Date",
                icon = Icons.Default.DateRange,
                onClick = { showDatePicker = true }
            )

            // ── Time Picker button ──
            FullWidthIconButton(
                text = "Pick Time",
                icon = Icons.Default.Schedule,
                onClick = { showTimePicker = true },
                filled = false
            )
        }
    }

    /* ── Date Picker Dialog ── */
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = { showDatePicker = false },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                showModeToggle = true
            )
        }
    }

    /* ── Time Picker Dialog ── */
    if (showTimePicker) {
        AlertDialog(
            onDismissRequest = { showTimePicker = false },
            confirmButton = {
                TextButton(
                    onClick = { showTimePicker = false },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showTimePicker = false }) {
                    Text("Cancel")
                }
            },
            text = {
                TimePicker(state = timePickerState)
            }
        )
    }
}
