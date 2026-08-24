package com.example.androidPortfolio.features.ingredients.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BasicAlertDialog
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.androidPortfolio.R
import com.example.androidPortfolio.core.ui.theme.PortfolioTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenFullScreenDialog(
    title: String,
    // onBack: () -> Unit,
) {
    var showDialog by remember { mutableStateOf(true) }

    val context = LocalContext.current

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
                Text(text = "Show Full Screen Dialog")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            if (showDialog) {
                BasicAlertDialog(
                    onDismissRequest = { showDialog = false },
                    modifier = Modifier,
                    properties = DialogProperties(
                        dismissOnBackPress = true,
                        dismissOnClickOutside = true,
                        usePlatformDefaultWidth = false,
                        decorFitsSystemWindows = true
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row (
                                modifier = Modifier.weight(1f)
                            ){
                                Row(
                                    modifier = Modifier
                                        .height(48.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    IconButton(
                                        onClick = {}
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(48.dp),
                                            painter = painterResource(R.drawable.ic_outline_close),
                                            contentDescription = "Close",
                                            tint = colorResource(R.color.black)
                                        )
                                    }

                                    Text("Full Screen Dialog Title")
                                }

                                TextButton(
                                    onClick = {}
                                ) {
                                    Text("Share")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ScreenFullScreenDialogPreview() {
    PortfolioTheme {
        ScreenFullScreenDialog(
            title = "Full Screen Dialog",
            // onBack = {},
        )
    }
}