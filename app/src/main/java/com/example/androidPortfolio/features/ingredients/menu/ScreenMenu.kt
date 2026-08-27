package com.example.androidPortfolio.features.ingredients.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenMenu(
    onBack: () -> Unit,
    title: String = "Menu",
) {
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
    var selectedDropdownItem by remember { mutableStateOf(value = dropdownItems.first()) }
    var expanded by remember { mutableStateOf(value = false) }

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
                        text = when (expanded) {
                            true -> "Selected: ${selectedDropdownItem.title}"
                            false -> title
                        },
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                actions = {

                    Box {
                        IconButton(
                            onClick = { if (!expanded) expanded = true }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Settings"
                            )
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            shape = RoundedCornerShape(16.dp),
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            modifier = Modifier.widthIn(min = 150.dp)
                        ) {
                            dropdownItems.forEach { item ->
                                val isSelected = item == selectedDropdownItem

                                DropdownMenuItem(
                                    modifier = Modifier.then(
                                        other = if (isSelected) {
                                            Modifier.background(
                                                color = MaterialTheme
                                                    .colorScheme
                                                    .primaryContainer
                                                    .copy(alpha = 0.5f)
                                            )
                                        } else {
                                            Modifier
                                        }
                                    ),
                                    text = { Text(item.title) },
                                    onClick = {
                                        selectedDropdownItem = item
                                        item.onClick()
//                                        expanded = false

                                        if (item.shouldDismissOnClick) {
                                            expanded = false
                                        }
                                    },
                                    leadingIcon = item.icon?.let { icon ->
                                        {
                                            Icon(
                                                imageVector = icon,
                                                contentDescription = null
                                            )
                                        }
                                    },

                                    trailingIcon = if (isSelected) {
                                        {
                                            Icon(
                                                imageVector = Icons.Default.Check,
                                                contentDescription = "Check",
                                                tint = MaterialTheme.colorScheme.primary
                                            )
                                        }
                                    } else null
                                )
                            }
                        }
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) { }
    }
}

data class DropdownItem(
    val title: String,
    val icon: ImageVector? = null,
    val backgroundColor: Color? = null,
    val shouldDismissOnClick: Boolean = false,
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