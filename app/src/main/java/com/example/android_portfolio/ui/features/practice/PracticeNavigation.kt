package com.example.android_portfolio.ui.features.practice

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.android_portfolio.navigation.PracticeDetailRoute
import com.example.android_portfolio.navigation.PracticeGraph
import com.example.android_portfolio.navigation.PracticeListRoute

fun NavGraphBuilder.practiceGraph(navController: NavController){
    navigation<PracticeGraph>(startDestination = PracticeListRoute) {
        composable<PracticeListRoute> {
            PracticeListScreen(
                onItemClick = { id ->
                    navController.navigate(PracticeDetailRoute(itemId = id))
                }
            )
        }

        composable<PracticeDetailRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<PracticeDetailRoute>()
            PracticeDetailScreen(itemId = args.itemId)
        }
    }
}

// Temporary placeholder for Detail Screen
@androidx.compose.runtime.Composable
fun PracticeDetailScreen(itemId: String) {
    androidx.compose.material3.Text(text = "Practice Detail: $itemId")
}
