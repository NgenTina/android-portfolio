package com.example.android_portfolio.ui.features.practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.android_portfolio.data.repository.ProjectRepository
import com.example.android_portfolio.ui.components.ProjectCard

@Composable
fun PracticeListScreen(
    onItemClick: (String) -> Unit
) {
    val items = ProjectRepository.getPracticeItems()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { practiceItem ->
            ProjectCard(
                item = practiceItem,
                onClick = { onItemClick(practiceItem.id) }
            )
        }
    }
}
