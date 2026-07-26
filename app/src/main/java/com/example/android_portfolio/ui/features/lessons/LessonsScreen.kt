package com.example.android_portfolio.ui.features.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.android_portfolio.data.repository.ProjectRepository
import com.example.android_portfolio.ui.components.ProjectCard

@Composable
fun LessonsScreen(
    onLessonClick: (String) -> Unit
) {
    val lessons = ProjectRepository.getLessons()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(lessons) { lesson ->
            ProjectCard(
                item = lesson,
                onClick = { onLessonClick(lesson.id) }
            )
        }
    }
}
