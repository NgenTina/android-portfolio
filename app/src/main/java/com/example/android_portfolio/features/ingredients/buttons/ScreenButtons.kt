package com.example.android_portfolio.features.ingredients.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_portfolio.core.ui.theme.Tertiary80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenButtons(
    title: String,
) {
    var clickCount by remember { mutableIntStateOf(0) }
    var selectedSegment by remember { mutableIntStateOf(0) }
    val segmentOptions = listOf("Day", "Week", "Month")

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { clickCount++ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = { Text(title) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { clickCount++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add Item")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Total Clicks: $clickCount",
                style = MaterialTheme.typography.titleMedium
            )

            // Filled Button
            Button(
                onClick = { clickCount++ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Filled Button (Primary)")
            }

            // Filled Tonal Button
            FilledTonalButton(
                onClick = { clickCount++ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Filled Tonal Button")
            }

            // Elevated Button
            ElevatedButton(
                onClick = { clickCount++ },
                modifier = Modifier.fillMaxWidth(),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp
                )
            ) {
                Text("Elevated Button")
            }

            // Outlined Button
            OutlinedButton(
                onClick = {
                    clickCount++
                    println("Click on Outlined Button")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Outlined Button")
            }

            // Text Button
            TextButton(
                onClick = {
                    clickCount++
                    println("Click on Text Button")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Text Button")
            }

            // Icon Buttons Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        clickCount++
                        println("Clicked on IconButton")
                    },
                    modifier = Modifier.background(
                        color = Tertiary80,
                        shape = RoundedCornerShape(16.dp)
                    ),
                ) {
                    Icon(Icons.Default.Favorite, contentDescription = "Favorite")
                }
                FilledIconButton(onClick = {
                    clickCount++
                    println("Click on Filled IconButton")
                }) {
                    Icon(Icons.Default.Favorite, contentDescription = "Filled Favorite")
                }
                FilledTonalIconButton(onClick = {
                    clickCount++
                    println("Clicked on Tonal IconButton")
                }) {
                    Icon(Icons.Default.Favorite, contentDescription = "Tonal Favorite")
                }
            }

            // 7. Single Choice Segmented Button Row
            SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                segmentOptions.forEachIndexed { index, label ->
                    SegmentedButton(
                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = segmentOptions.size
                        ),
                        onClick = {
                            selectedSegment = index
                            println("Click on $label")
                        },
                        selected = index == selectedSegment
                    ) {
                        Text(label)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Button Gallery Preview")
@Composable
fun ScreenButtonsPreview() {
    MaterialTheme {
        ScreenButtons(
            title = "Button Screen"
        )
    }
}