package com.example.android_portfolio.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

import com.example.android_portfolio.screens.HomeScreen
import com.example.android_portfolio.screens.LessonsScreen
import com.example.android_portfolio.screens.PracticeScreen
import com.example.android_portfolio.screens.practice.RecipesScreen
import com.example.android_portfolio.screens.practice.mockRecipeSections

@Composable
fun AppNavigation() {
    Log.d("AppNavigation", "Initializing AppNavigation")
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // main screen
        composable(route = "home") {
             HomeScreen(navController)
        }

        // Category hubs
        composable(route = "lessons_hub") {
             LessonsScreen(navController)
        }
        composable(route = "practice_hub") {
             PracticeScreen(navController)
        }

        // individual pages
        composable(route = "recipe_ui") {
            RecipesScreen(
                sections = mockRecipeSections,
                onBackClick = { navController.popBackStack() },
                onMenuClick = { /* Handle menu */ }
            )
        }

    }
}