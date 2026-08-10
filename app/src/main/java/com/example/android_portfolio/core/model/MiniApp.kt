package com.example.android_portfolio.core.model

data class MiniApp(
    override val id: String,
    override val title: String,
    override val description: String,
    override val category: String,
    override val date: String,
    val projectType: String
) : PortfolioItem
