package com.example.androidPortfolio.features.ingredients

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.androidPortfolio.navigation.LessonDetailRoute
import com.example.androidPortfolio.navigation.LessonListRoute
import com.example.androidPortfolio.navigation.LessonsGraph

fun NavGraphBuilder.featureGraph(
    navController: NavController
) {
    navigation<LessonsGraph>(startDestination = LessonListRoute) {
        composable<LessonListRoute> {
            FeatureListScreen(
                onFeatureClick = { id ->
                    navController.navigate(LessonDetailRoute(lessonId = id))
                }
            )
        }
        
        composable<LessonDetailRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<LessonDetailRoute>()
            FeatureDetailScreen(featureId = args.lessonId)
        }
    }
}

@androidx.compose.runtime.Composable
fun FeatureDetailScreen(featureId: String) {
    androidx.compose.material3.Text(text = "Feature Detail: $featureId")
}
