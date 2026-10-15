package com.example.androidPortfolio.features.components

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

import com.example.androidPortfolio.navigation.ComponentCategory
import com.example.androidPortfolio.navigation.ComponentDetail
import com.example.androidPortfolio.navigation.Components

fun NavGraphBuilder.componentsGraph(
    navController: NavController
) {
    // Components main screen
    composable<Components> {
        ComponentsScreen(
            onCategoryClick = { category ->
                navController.navigate(
                    route = ComponentCategory(
                        categoryId = category.id
                    )
                )
            }
        )
    }

    // Components within a selected category
    composable<ComponentCategory> { backStackEntry ->
        val route = backStackEntry.toRoute<ComponentCategory>()

        ComponentCategoryScreen(
            categoryId = route.categoryId,
            componentCategories = componentCategories,
            componentsByCategory = componentsByCategory,
            onComponentClick = { component ->
                navController.navigate(
                    ComponentDetail(
                        categoryId = route.categoryId,
                        componentId = component.id
                    )
                )
            },
            onBackClick = {
                navController.popBackStack()
            }
        )
    }

    // Selected component details
    composable<ComponentDetail> { backStackEntry ->
        val route = backStackEntry.toRoute<ComponentDetail>()

        ComponentDetailScreen(
            categoryId = route.categoryId,
            componentId = route.componentId,
            onBackClick = {
                navController.popBackStack()
            }
        )
    }
}