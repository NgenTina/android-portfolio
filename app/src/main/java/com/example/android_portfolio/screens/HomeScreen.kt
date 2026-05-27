package com.example.android_portfolio.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.android_portfolio.model.MenuItem

@Composable
fun HomeScreen(navController: NavController){
    Log.d("HomeScreen", "Rendering HomeScreen")
    // list of screens
    val menuList = listOf(
        MenuItem("Lessons", "lessons_hub"),
        MenuItem("Practice", "practice_hub")
    )

    Scaffold(
        content = { innerPadding ->

            // Text()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(menuList) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable{
                                navController.navigate(item.route)
                            },
                        colors = androidx.compose.material3.CardDefaults.cardColors(
                            containerColor = Color.LightGray
                        )
                    ) {
                        Text(
                            text = item.title,
                            color = Color.Black,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(20.dp)
                        )
                    }
                }
            }
        }
    )

}
