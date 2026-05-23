package com.example.android_portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_portfolio.navigation.AppNavigation
import com.example.android_portfolio.ui.practice.ScaffoldPractice01
import com.example.android_portfolio.ui.theme.AndroidPortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPortfolioTheme {
                // ScaffoldPractice01()
                AppNavigation()
            }
        }
    }
}

// composable for testing
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidPortfolioTheme {
        // Greeting("Android")
        AppNavigation()
    }
}