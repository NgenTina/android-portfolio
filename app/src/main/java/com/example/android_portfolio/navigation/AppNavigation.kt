package com.example.android_portfolio.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

import com.example.android_portfolio.screens.HomeScreen
import com.example.android_portfolio.screens.LessonsScreen
import com.example.android_portfolio.screens.PracticeScreen
import com.example.android_portfolio.screens.practice.DateTimePickerScreen
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
        composable(route = Screen.Home.route) { HomeScreen(navController) }

        // Category hubs
        composable(route = Screen.LessonsHub.route) { LessonsScreen(navController) }
        composable(route = Screen.PracticeHub.route) { PracticeScreen(navController) }

        // individual pages
        composable(route = Screen.Recipes.route) {
            RecipesScreen(
                sections = mockRecipeSections,
                onBackClick = { navController.popBackStack() },
                onMenuClick = { /* Handle menu */ }
            )
        }

        composable(route = Screen.DateTimePicker.route) { DateTimePickerScreen() }

    }
}