package com.example.androidPortfolio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.androidPortfolio.features.components.componentsGraph
import com.example.androidPortfolio.features.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {
        // Home screen
        composable<Home> {
            HomeScreen(
                onLibraryClick = {
                    navController.navigate(route = Components)
                }
            )
        }

        // Components graph
        componentsGraph(navController)
    }
}