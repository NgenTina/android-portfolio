package com.example.android_portfolio.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_portfolio.components.lessons.LessonsCard
import com.example.android_portfolio.model.MenuItem


data class LessonItem (
    override val title: String,
    override val route: String,
    val description: String,
) : MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonsScreen(navController: NavController) {
    val lessonsList = listOf(
        LessonItem(
            "Jetpack Compose Basics",
            "lesson_compose_basics",
            "Learn the fundamentals of declarative UI",
        ),
        LessonItem(
            "State Management",
            "lesson_state",
            "Handle UI state with ViewModel & remember",
        ),
        LessonItem(
            "Navigation",
            "lesson_navigation",
            "Navigate between Screen with compose",
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lessons List") },
                navigationIcon = {
                    IconButton( onClick = { navController.popBackStack() }) {
                        Icon( Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Black" )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(lessonsList) { item ->
                    LessonsCard(item) {
                        navController.navigate(item.route)
                    }
                }
            }
        }
    )
}