package com.example.android_portfolio.feature.ingredients

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.android_portfolio.core.data.repository.ProjectRepository
import com.example.android_portfolio.core.ui.components.ProjectCard

@Composable
fun FeatureListScreen(
    onFeatureClick: (String) -> Unit
) {
    val features = ProjectRepository.getFeatures()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(features) { feature ->
            ProjectCard(
                item = feature,
                onClick = { onFeatureClick(feature.id) }
            )
        }
    }
}
