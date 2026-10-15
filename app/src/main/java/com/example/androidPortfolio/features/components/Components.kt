package com.example.androidPortfolio.features.components

data class ComponentCategoryItem(
    val id: String,
    val title: String,
    val description: String
)

data class ComponentItem(
    val id: String,
    val title: String,
    val description: String
)

val componentCategories = listOf(
    ComponentCategoryItem(
        id = "dialogs",
        title = "Dialogs",
        description = "Alerts and confirmation dialogs."
    ),
    ComponentCategoryItem(
        id = "progressIndicators",
        title = "Progress Indicators",
        description = "Loading indicators and progress feedback."
    )
)

val componentsByCategory: Map<String, List<ComponentItem>> = mapOf(
    "dialogs" to listOf(
        ComponentItem(
            id = "alertDialog",
            title = "Alert Dialog",
            description = "Displays a message and asks the user to respond."
        )
    ),
    "progressIndicators" to listOf(
        ComponentItem(
            id = "circularProgressIndicator",
            title = "Circular Progress Indicator",
            description = "Shows progress using a circular indicator."
        ),
    )
)
