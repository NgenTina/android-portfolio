package com.example.androidPortfolio.features.ingredients.dialogs

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidPortfolio.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenDialog(
    title: String,
    // onBack: () -> Unit,
) {
    var showDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current

    fun onActionDialog(message: String) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.show()
    }

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        // Top App Bar
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        // Bottom Bar
        bottomBar = {
            Button(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                onClick = { showDialog = true }
            ) {
                Text(text = "Show Dialog")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            if (showDialog) {
                AlertDialog(
//                    modifier = Modifier.fillMaxSize(),
//                    properties = DialogProperties(
//                        dismissOnBackPress = true,
//                        dismissOnClickOutside = true,
//                        usePlatformDefaultWidth = false,
//                        decorFitsSystemWindows = true
//                    ),
                    shape = RoundedCornerShape(8.dp),
                    icon = {
                        Icon(
                            modifier = Modifier.size(48.dp),
                            imageVector = Icons.Default.Warning,
                            contentDescription = "Warning"
                        )
                    },
                    onDismissRequest = { showDialog = false },

                    confirmButton = {
                        TextButton(
                            onClick = {
                                println("Confirm button clicked")
                                showDialog = false
                                onActionDialog("Removed Successfully")
                            }
                        ) {
                            Text(stringResource(R.string.label_confirm))
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                showDialog = false
                                println("Dismiss button clicked")
                                onActionDialog("Cancelled Removing Data")
                            }
                        ) {
                            Text(stringResource(R.string.label_cancel))
                        }
                    },
                    title = {
                        Text(text = "Data Removed")
                    },
                    text = {
                        Text(text = "Are you sure you want to remove this data?")
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun ScreenDialogPreview() {
    MaterialTheme {
        ScreenDialog(
            title = "Dialog Screen",
            // onBack = {},
        )
    }
}