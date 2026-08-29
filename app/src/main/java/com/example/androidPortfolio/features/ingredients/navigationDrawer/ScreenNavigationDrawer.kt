package com.example.androidPortfolio.features.ingredients.navigationDrawer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidPortfolio.core.ui.theme.PortfolioTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNavigationDrawer(
    onBack: () -> Unit,
    title: String = "Bottom Navigation Bar",
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var selectedItem by remember { mutableStateOf("Item 1") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .statusBarsPadding()
                    .padding(horizontal = 12.dp)
                    .verticalScroll(state = rememberScrollState())
            ) {
                Spacer(Modifier.height(16.dp))
                Text(
                    "Drawer Title",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                Text(
                    "Section 1",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline,
                )

                NavigationDrawerItem(
                    label = { Text("Item 1") },
                    selected = selectedItem == "Item 1",
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    onClick = {
                        selectedItem = "Item 1"
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(paddingValues = NavigationDrawerItemDefaults.ItemPadding)
                )
                NavigationDrawerItem(
                    label = { Text("Item 2") },
                    selected = selectedItem == "Item 2",
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
                    onClick = {
                        selectedItem = "Item 2"
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(paddingValues = NavigationDrawerItemDefaults.ItemPadding)
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

                Text(
                    text = "Section 2",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.outline,
                )
                NavigationDrawerItem(
                    label = { Text("Settings") },
                    selected = selectedItem == "Settings",
                    icon = { Icon(imageVector = Icons.Outlined.Settings, contentDescription = null) },
                    badge = { Text("20") },
                    onClick = {
                        selectedItem = "Settings"
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(paddingValues = NavigationDrawerItemDefaults.ItemPadding)
                )
                NavigationDrawerItem(
                    label = { Text("Help & feedback") },
                    selected = selectedItem == "Help & feedback",
                    icon = { Icon(Icons.AutoMirrored.Outlined.Help, contentDescription = null) },
                    onClick = {
                        selectedItem = "Help & feedback"
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
                Spacer(Modifier.height(16.dp))
            }
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = title)
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                } else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Settings",
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    ),
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center,
            ) {
                Text("Ok")
            }
        }
    }
}

@Preview
@Composable
fun ScreenNavigationDrawerPreview() {
    PortfolioTheme {
        ScreenNavigationDrawer(
            onBack = { println("Back button clicked") },
            title = "Navigation Drawer",
        )
    }
}