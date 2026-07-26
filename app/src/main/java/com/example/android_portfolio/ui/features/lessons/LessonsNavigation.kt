package com.example.android_portfolio.ui.features.lessons

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.android_portfolio.navigation.LessonDetailRoute
import com.example.android_portfolio.navigation.LessonListRoute
import com.example.android_portfolio.navigation.LessonsGraph

fun NavGraphBuilder.lessonsGraph(
    navController: NavController
) {
    navigation<LessonsGraph>(startDestination = LessonListRoute) {
        composable<LessonListRoute> {
            LessonsScreen(
                onLessonClick = { id ->
                    navController.navigate(LessonDetailRoute(lessonId = id))
                }
            )
        }
        
        composable<LessonDetailRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<LessonDetailRoute>()
            // For now, just show a placeholder or the detail screen
            LessonDetailScreen(lessonId = args.lessonId)
        }
    }
}

// Temporary placeholder for Detail Screen
@androidx.compose.runtime.Composable
fun LessonDetailScreen(lessonId: String) {
    androidx.compose.material3.Text(text = "Lesson Detail: $lessonId")
}
