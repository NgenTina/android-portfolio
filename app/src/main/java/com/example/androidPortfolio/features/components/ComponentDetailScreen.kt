package com.example.androidPortfolio.features.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidPortfolio.features.components.appbars.ScreenAppBars
import com.example.androidPortfolio.features.components.bottomSheets.ScreenBottomSheet
import com.example.androidPortfolio.features.components.bottomSheets.ScreenPartialBottomSheet
import com.example.androidPortfolio.features.components.buttons.ScreenButtons
import com.example.androidPortfolio.features.components.dialogs.ScreenDialog
import com.example.androidPortfolio.features.components.dialogs.ScreenFullScreenDialog
import com.example.androidPortfolio.features.components.menu.ScreenMenu
import com.example.androidPortfolio.features.components.menu.dropdownItems
import com.example.androidPortfolio.features.components.navigationBar.ScreenBottomNavigationBar
import com.example.androidPortfolio.features.components.navigationDrawer.ScreenNavigationDrawer
import com.example.androidPortfolio.features.components.progressIndicators.ScreenProgressIndicator
import com.example.androidPortfolio.features.components.radios.ScreenRadio
import com.example.androidPortfolio.features.components.radios.ScreenScrollRadio

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentDetailScreen(
    categoryId: String,
    componentId: String,
    onBackClick: () -> Unit
) {
    val category = componentCategories.find { it.id == categoryId }
    val component = componentsByCategory[categoryId]?.find { it.id == componentId }

    var showFullScreenDemo by remember { mutableStateOf(false) }

    if (showFullScreenDemo) {
        when (componentId) {
            "button", "filledTonalButton", "elevatedButton", "outlinedButton", "textButton", "segmentedButton" -> {
                ScreenButtons(
                    title = component?.title ?: "Buttons Demo",
                    onBackClick = { showFullScreenDemo = false }
                )
            }
            "alertDialog" -> {
                ScreenDialog(
                    title = "Alert Dialog Demo",
                    onBack = { showFullScreenDemo = false }
                )
            }
            "fullScreenDialog" -> {
                ScreenFullScreenDialog(
                    title = "Full Screen Dialog Demo",
                    onBack = { showFullScreenDemo = false }
                )
            }
            "circularProgressIndicator", "linearProgressIndicator" -> {
                ScreenProgressIndicator(
                    title = "Progress Indicator Demo",
                    onBack = { showFullScreenDemo = false }
                )
            }
            "centerAlignedTopAppBar" -> {
                ScreenAppBars(
                    title = "App Bar Demo",
                    onBackClick = { showFullScreenDemo = false }
                )
            }
            "modalBottomSheet" -> {
                ScreenBottomSheet(
                    title = "Modal Bottom Sheet Demo",
                    onBack = { showFullScreenDemo = false },
                    onDismiss = {}
                )
            }
            "partialBottomSheet" -> {
                ScreenPartialBottomSheet(
                    title = "Partial Bottom Sheet Demo",
                    onBack = { showFullScreenDemo = false }
                )
            }
            "dropdownMenu" -> {
                ScreenMenu(
                    title = "Dropdown Menu Demo",
                    onBack = { showFullScreenDemo = false },
                    dropdownItems = dropdownItems
                )
            }
            "bottomNavigationBar" -> {
                ScreenBottomNavigationBar(
                    title = "Bottom Navigation Demo",
                    onBack = { showFullScreenDemo = false }
                )
            }
            "modalNavigationDrawer" -> {
                ScreenNavigationDrawer(
                    title = "Navigation Drawer Demo",
                    onBack = { showFullScreenDemo = false }
                )
            }
            "radioButton" -> {
                ScreenRadio(
                    title = "Radio Button Demo",
                    onBack = { showFullScreenDemo = false }
                )
            }
            "scrollRadio" -> {
                ScreenScrollRadio(
                    title = "Scrollable Radio Demo",
                    onBack = { showFullScreenDemo = false }
                )
            }
            else -> {
                ScreenButtons(
                    title = component?.title ?: "Component Demo",
                    onBackClick = { showFullScreenDemo = false }
                )
            }
        }
        return
    }

    var demoClicked by remember { mutableStateOf(false) }
    var selectedSegment by remember { mutableIntStateOf(0) }
    var selectedRadio by remember { mutableIntStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = component?.title ?: "Component Details",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (component == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Component not found.")
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = category?.title ?: "Components",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = component.title,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = component.description,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Text(
                    text = "Interactive Preview",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        when (componentId) {
                            "button" -> {
                                Button(onClick = { demoClicked = !demoClicked }) {
                                    Text(if (demoClicked) "Clicked!" else "Primary Button")
                                }
                            }
                            "filledTonalButton" -> {
                                FilledTonalButton(onClick = { demoClicked = !demoClicked }) {
                                    Text(if (demoClicked) "Clicked!" else "Tonal Button")
                                }
                            }
                            "elevatedButton" -> {
                                ElevatedButton(onClick = { demoClicked = !demoClicked }) {
                                    Text(if (demoClicked) "Clicked!" else "Elevated Button")
                                }
                            }
                            "outlinedButton" -> {
                                OutlinedButton(onClick = { demoClicked = !demoClicked }) {
                                    Text(if (demoClicked) "Clicked!" else "Outlined Button")
                                }
                            }
                            "textButton" -> {
                                TextButton(onClick = { demoClicked = !demoClicked }) {
                                    Text(if (demoClicked) "Clicked!" else "Text Button")
                                }
                            }
                            "segmentedButton" -> {
                                val options = listOf("Option A", "Option B", "Option C")
                                SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                                    options.forEachIndexed { index, label ->
                                        SegmentedButton(
                                            shape = SegmentedButtonDefaults.itemShape(
                                                index = index,
                                                count = options.size
                                            ),
                                            onClick = { selectedSegment = index },
                                            selected = index == selectedSegment
                                        ) {
                                            Text(label)
                                        }
                                    }
                                }
                            }
                            "circularProgressIndicator" -> {
                                CircularProgressIndicator()
                            }
                            "linearProgressIndicator" -> {
                                LinearProgressIndicator(
                                    progress = { 0.7f },
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                            "radioButton", "scrollRadio" -> {
                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    listOf("Option 1", "Option 2").forEachIndexed { index, label ->
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            RadioButton(
                                                selected = selectedRadio == index + 1,
                                                onClick = { selectedRadio = index + 1 }
                                            )
                                            Text(label)
                                        }
                                    }
                                }
                            }
                            else -> {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Text(
                                        text = component.title,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Text(
                                        text = "Tap launch below for full screen interactive view",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                        }
                    }
                }

                Button(
                    onClick = { showFullScreenDemo = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Text("Launch Full Screen Interactive Demo")
                }

                Text(
                    text = "Component ID",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = component.id,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Back to components")
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
