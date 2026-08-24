package com.example.androidPortfolio.features.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.androidPortfolio.core.data.repository.ProjectRepository
import com.example.androidPortfolio.core.ui.components.ProjectCard

@Composable
fun PracticeListScreen(
    onItemClick: (String) -> Unit
) {
    val items = ProjectRepository.getMiniApps()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { miniApp ->
            ProjectCard(
                item = miniApp,
                onClick = { onItemClick(miniApp.id) }
            )
        }
    }
}
