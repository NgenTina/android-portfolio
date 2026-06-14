package com.example.android_portfolio.model

interface MenuItem {
    val title: String
    val route: String
}

data class SimpleMenuItem(
    override val title: String,
    override val route: String
) : MenuItem