package com.example.android_portfolio.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_portfolio.model.MenuItem

@Composable
fun LessonsScreen(navController: NavController) {
    val lessonsList = listOf(
        MenuItem("Jetpack Compose Basics", "lesson_compose_basics"),
        MenuItem("State Management", "lesson_state"),
        MenuItem("Navigation", "lesson_navigation")
    )

    Scaffold(
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(lessonsList) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable{
                                navController.navigate(item.route)
                            }
                    ) {
                        Text(
                            text = item.title,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    )
}