package com.example.androidPortfolio.features.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComponentsScreen(
    onCategoryClick: (ComponentCategoryItem) -> Unit
) {
    LazyColumn{
        items(componentCategories ) { category ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable {
                        onCategoryClick(category)
                    }
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = category.title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = category.description
                    )
                }
            }
        }
    }
}