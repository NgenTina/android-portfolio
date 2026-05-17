package com.example.android_portfolio.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.android_portfolio.screens.practice.RecipeSection

@Composable
fun RecipeHorizontalSection(
    section: RecipeSection,
    onSeeAllClick: () -> Unit
) {
    Column() {
        SectionHeader(
            title = section.categoryName,
            onSeeAllClick = onSeeAllClick
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(section.items) { item ->
                RecipeCard(item = item)
            }
        }
    }
}