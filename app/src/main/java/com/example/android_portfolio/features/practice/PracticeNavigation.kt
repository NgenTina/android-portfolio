package com.example.android_portfolio.features.practice

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
            MiniAppDetailScreen(itemId = args.itemId)
        }
    }
}

@androidx.compose.runtime.Composable
fun MiniAppDetailScreen(itemId: String) {
    androidx.compose.material3.Text(text = "Mini App Detail: $itemId")
}
