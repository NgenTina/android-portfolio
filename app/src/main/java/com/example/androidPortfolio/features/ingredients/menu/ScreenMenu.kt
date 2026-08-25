package com.example.androidPortfolio.features.ingredients.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMenu(
    onBack: () -> Unit,
    title: String = "Menu",
) {
    Scaffold(
        // Top App Bar
        topBar = {
            TopAppBar(
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
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                actions = {

                    var expanded by remember { mutableStateOf(false) }

                    val dropdownItems = listOf(
                        DropdownItem(
                            title = "Settings",
                            icon = Icons.Default.Settings,
                            onClick = {
                                println("Settings clicked")
                            }
                        ),
                        DropdownItem(
                            title = "Help",
                            icon = Icons.Default.Info,
                            onClick = {
                                println("Help clicked")
                            }
                        ),
                        DropdownItem(
                            title = "About",
                            icon = Icons.Default.Info,
                            onClick = {
                                println("About clicked")
                            }
                        )
                    )

                    IconButton(
                        onClick = {
                            expanded = !expanded
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Settings"
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        },
                    ) {
                        dropdownItems.forEach { item ->
                            DropdownMenuItem(
                                text = {
                                    Text(item.title)
                                },
                                onClick = {
                                    expanded = false
                                    item.onClick()
                                },
                                leadingIcon = item.icon?.let { icon ->
                                    {
                                        Icon(
                                            imageVector = icon,
                                            contentDescription = item.title
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            )
        },
    ) { innerPadding ->
        println(innerPadding)
        Column { }
    }
}

data class DropdownItem(
    val title: String,
    val icon: ImageVector? = null,
    val onClick: () -> Unit
)

@Preview
@Composable
fun ScreenMenuPreview() {
    ScreenMenu(
        onBack = {},
        title = "Menu Screen"
    )
}