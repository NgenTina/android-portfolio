package com.example.android_portfolio.screens.practice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CoffeeSelectionContent() {
    val coffees = listOf(
        "Ice Latte",
        "Ice Espresso",
        "Ice Americano",
        "Hot Cappuccino",
        "Ice Mocha"
    )

    var selectedCoffee by rememberSaveable  { mutableStateOf("Ice Latte") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        CoffeeGroup(
            title = "Choose coffee",
            options = coffees,
            selectedOption = selectedCoffee,
            onOptionSelected = { selectedCoffee = it }
        )
    }
}

@Composable
fun CoffeeGroup(
    title: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Text(
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.Normal,
        color = Color(0xFF333333),
        modifier = Modifier.padding(bottom = 8.dp)
    )

    options.forEach { option ->
        CoffeeRadioButton(
            text = option,
            selected = option == selectedOption,
            onClick = { onOptionSelected(option) }
        )
    }
}