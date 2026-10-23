package com.example.androidPortfolio.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.androidPortfolio.features.about.AboutScreen
import com.example.androidPortfolio.features.components.componentsGraph
import com.example.androidPortfolio.features.concepts.ConceptsScreen
import com.example.androidPortfolio.features.home.HomeScreen
import com.example.androidPortfolio.features.miniapps.MiniAppsScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            PortfolioNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Home screen
            composable<Home> {
                HomeScreen(
                    onLibraryClick = {
                        navController.navigate(route = Components)
                    },
                    onMiniAppsClick = {
                        navController.navigate(route = MiniApps)
                    },
                    onComponentsClick = {
                        navController.navigate(route = Components)
                    }
                )
            }

            // About screen
            composable<About> {
                AboutScreen()
            }

            // Mini Apps screen
            composable<MiniApps> {
                MiniAppsScreen()
            }

            // Other Concepts screen
            composable<OtherConcepts> {
                ConceptsScreen()
            }

            // Components graph
            componentsGraph(navController)
        }
    }
}
