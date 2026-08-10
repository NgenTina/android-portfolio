package com.example.android_portfolio.data.models

data class PracticeItem(
    override val id: String,
    override val title: String,
    override val description: String,
    override val category: String,
    override val date: String,
    val projectType: String // e.g., "UI Challenge", "Mini App", "Feature Demo"
) : ProjectItem
