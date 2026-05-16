package com.example.android_portfolio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

import com.example.android_portfolio.screens.HomeScreen

@Composable
fun AppNavigation() {

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
        composable(route = "lesson_hub") {
            // LessonScreen(navController)
        }
        composable(route = "practice_hub") {
            // PracticeScreen(navController)
        }

        // indiv pages

    }
}