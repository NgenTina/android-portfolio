package com.example.android_portfolio.screens.practice

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.android_portfolio.R
import com.example.android_portfolio.ui.RecipeHorizontalSection

// model
data class RecipeCardItem(
    val title: String,
    val durationText: String,
    val typeText: String,
    @DrawableRes val imageRes: Int
)

data class RecipeSection(
    val categoryName: String,
    val items: List<RecipeCardItem>
)

// data
val mockRecipeSections = listOf(
    RecipeSection(
        categoryName = "Snacks",
        items = listOf(
            RecipeCardItem("Morning stretch", "15 min", "Workout", R.drawable.cucumber_snack),
            RecipeCardItem("Battle ropes basic", "15 min", "Workout", R.drawable.other_snack)
        )
    ),
    RecipeSection(
        categoryName = "Breakfast",
        items = listOf(
            RecipeCardItem("Beginner circuit training", "15 min", "Workout", R.drawable.toast_breakfast),
            RecipeCardItem("Get active", "15 min", "Workout", R.drawable.other_breakfast)
        )
    ),
    RecipeSection(
        categoryName = "Lunch",
        items = listOf(
            RecipeCardItem("Core booster", "20 min", "Workout", R.drawable.sweet_potato_lunch)
        )
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipesScreen(
    sections: List<RecipeSection>,
    onBackClick: () -> Unit,
    onMenuClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Recipes",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onMenuClick) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More Options")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sections) { section ->
                RecipeHorizontalSection(
                    section = section,
                    onSeeAllClick = { /* Handle navigation to view all */ }
                )
            }
        }
    }
}