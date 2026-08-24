package com.example.androidPortfolio.core.model

data class Feature(
    override val id: String,
    override val title: String,
    override val description: String,
    override val category: String,
    override val date: String,
    val featureNumber: Int,
    val isCompleted: Boolean = false
) : PortfolioItem
