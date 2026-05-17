package com.example.android_portfolio.ui.practice

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

// copy ke -> merl lerng vinh
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldPractice01() {
    Scaffold(
        // scaffold top bar
        topBar = {
            TopAppBar(
                title = { Text("TopAppBar") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF037BFF),
                    titleContentColor = Color.White
                )
            )
        },

        // float button
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = {}){
                Text("X")
            }
        },

        // scaffold contents
        content = { innerPadding ->
            Text(
                text = "BodyContent",
                modifier = Modifier.padding(innerPadding)
            )
        },

        // scaffold bottom bar
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFB100FC),
                contentColor = Color.White
            ) {
                Text("BottomAppBar")
            }
        }
    )
}

@Composable
fun ScaffoldPractice02() {
    Scaffold(
        content = { innerPadding ->
            Text(text = "Practice 02 Content", modifier = Modifier.padding(innerPadding))
        }
    )
}
