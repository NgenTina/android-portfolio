package com.example.androidPortfolio.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidPortfolio.features.about.AboutScreen
import com.example.androidPortfolio.features.home.HomeScreen
import com.example.androidPortfolio.features.components.componentsGraph
import com.example.androidPortfolio.features.miniApps.miniAppsGraph
import com.example.androidPortfolio.features.otherConcepts.otherConceptsGraph

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            PortfolioNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Home
            composable<Home> {
                HomeScreen(
                    onAboutClick = {
                        navController.navigate(About)
                    },
                    onMiniAppsClick = {
                        navController.navigate(MiniApps)
                    },
                    onComponentsClick = {
                        navController.navigate(Components)
                    },
                    onConceptsClick = {
                        navController.navigate(OtherConcepts)
                    }
                )
            }

            // About
            composable<About> {
                AboutScreen()
            }

            // Feature graphs
            componentsGraph(navController)
            miniAppsGraph(navController)
            otherConceptsGraph(navController)
        }
    }
}