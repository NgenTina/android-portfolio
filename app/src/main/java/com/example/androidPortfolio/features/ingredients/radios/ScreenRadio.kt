package com.example.androidPortfolio.features.ingredients.radios

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

data class RadioItem(
    val id: Int,
    val title: String,
    val onClick: () -> Unit
)

val radioItems = listOf(
    RadioItem(
        id = 1,
        title = "Item 1",
        onClick = { println("Item 1 clicked") }
    ),
    RadioItem(
        id = 2,
        title = "Item 2",
        onClick = { println("Item 2 clicked") }
    ),
    RadioItem(
        id = 3,
        title = "Item 3",
        onClick = { println("Item 3 clicked") }
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRadio(
    onBack: () -> Unit,
    title: String = "Radio",
) {

    var selectedOption by remember { mutableStateOf(radioItems.first()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

//            Text("Select Top:")

            RadioGroupSection(
                radioItems = radioItems,
                selectedItem = selectedOption,
                onItemSelected = { newItem ->
                    selectedOption = newItem
                    println("Selected item: ${newItem.title}")
                }
            )
        }
    }
}

@Composable
fun RadioGroupSection(
    radioItems: List<RadioItem>,
    selectedItem: RadioItem,
    onItemSelected: (RadioItem) -> Unit
) {
    radioItems.forEach { option ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .clickable { onItemSelected(option) }
        ) {
            RadioButton(
                selected = (option == selectedItem),
                onClick = { onItemSelected(option) },
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(option.title)
        }
    }
}

@Preview
@Composable
fun ScreenRadioPreview() {
    PortfolioTheme {
        ScreenRadio(
            onBack = { println("Back button clicked") },
            title = "Radio",
        )
    }
}