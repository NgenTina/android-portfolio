package com.example.android_portfolio.feature.practice.recipes

import androidx.annotation.DrawableRes
import com.example.android_portfolio.R

/**
 * Data models for the recipe feature.
 *
 * Previously defined inline in RecipesScreen.kt — extracted here
 * so they can be shared between screens and components without
 * circular dependencies.
 */
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

// Sample data used by RecipesScreen
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
