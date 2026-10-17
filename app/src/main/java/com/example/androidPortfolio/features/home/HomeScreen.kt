package com.example.androidPortfolio.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onMiniAppsClick: () -> Unit,
    onComponentsClick: () -> Unit,
    onLibraryClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "ANDROID PORTFOLIO",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Build. Explore. Learn.",
            style = MaterialTheme.typography.headlineLarge
        )

        // Hero Cars
        HeroProfileCard(
            onViewMiniApps = onMiniAppsClick,
            onViewComponents = onComponentsClick
        )

        Text(
            text = "A collection of Android UI components built with Kotlin and Jetpack Compose.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(all = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Components Library",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "Explore reusable UI elements, Material components, and design patterns."
                )

                Button(
                    onClick = onLibraryClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Explore Components")
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Made with Kotlin & Jetpack Compose",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onLibraryClick = { println("Library clicked") },
        onMiniAppsClick = { println("Mini apps clicked") },
        onComponentsClick = { println("Components clicked") }
    )
}
