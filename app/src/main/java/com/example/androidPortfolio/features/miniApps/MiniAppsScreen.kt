package com.example.androidPortfolio.features.miniApps

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MiniAppsScreen(
    onMiniAppClick: (MiniApp) -> Unit
) {

    LazyColumn {

        items(miniApps) { miniApp ->

            MiniAppItem(
                miniApp = miniApp,
                onClick = {
                    onMiniAppClick(miniApp)
                }
            )
        }
    }
}


@Composable
private fun MiniAppItem(
    miniApp: MiniApp,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = miniApp.title,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = miniApp.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}