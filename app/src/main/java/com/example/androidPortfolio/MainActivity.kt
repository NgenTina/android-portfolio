package com.example.androidPortfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.androidPortfolio.core.ui.theme.PortfolioTheme
import com.example.androidPortfolio.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            PortfolioTheme {
                AppNavigation()
            }
        }
    }
}