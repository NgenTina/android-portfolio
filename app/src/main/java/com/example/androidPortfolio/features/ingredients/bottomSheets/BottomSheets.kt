package com.example.androidPortfolio.features.ingredients.bottomSheets

// TODO (review and implement later):
// [ ] Fix bottom sheet not rendering: lift ModalBottomSheet out of Scaffold's content lambda
//     so it is a sibling of Scaffold (not nested inside the content slot).
// [ ] Wire onDismiss callback: in onDismissRequest, set showBottomSheet = false AND invoke
//     the onDismiss() parameter so the parent is notified on scrim tap / drag-down.
// [ ] Decide Done-button semantics: confirm whether "Done" should only close the sheet
//     (local showBottomSheet = false) or also signal the parent (onDismiss()) — wire
//     SheetContent's onClose accordingly.
// [ ] Review callback naming: if `onDismiss` is meant for sheet-level dismissal, consider
//     renaming to `onSheetDismissed` to avoid confusion with screen-level "leave this
//     screen" events.
// [ ] Verify fix by running the app: open the bottom sheet via FAB and via the
//     "Show Bottom Sheet" button, confirm SheetContent (icon, title, body, Done) is
//     fully visible and the scrim/drag dismiss still works.

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidPortfolio.core.ui.theme.PortfolioTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenBottomSheet(
    onBack: () -> Unit,
    onDismiss: () -> Unit,
    title: String = "Bottom Sheet",
) {
    var showBottomSheet by remember { mutableStateOf(value = false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Scaffold(

        topBar = {

            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = { Text(text = title) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },

        floatingActionButton = {
            FloatingActionButton(onClick = { showBottomSheet = true }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
                .padding(all = 16.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Main Screen Content",
                style = MaterialTheme.typography.headlineMedium,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { showBottomSheet = true }) {
                Text("Show Bottom Sheet")
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
                onDismiss()
            },
            sheetState = sheetState,

        ) {
            SheetContent(onClose = { showBottomSheet = false })
        }
    }

}

@Composable
fun SheetContent(onClose: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Modal Bottom Sheet Title",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "This content appears over the Scaffold layout. Tapping the backdrop or dragging down dismisses it.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onClose,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Done")
        }
    }
}

@Preview
@Composable
fun ScreenBottomSheetPreview() {
    PortfolioTheme {
        ScreenBottomSheet(
            onBack = {
                println("Back button clicked")
            },
            onDismiss = {}
        )
    }
}