package com.example.androidPortfolio.core.data.repository

import com.example.androidPortfolio.core.model.Feature
import com.example.androidPortfolio.core.model.MiniApp

object ProjectRepository {
    fun getFeatures(): List<Feature> = listOf(
        Feature(
            id = "lesson_06",
            title = "Layouts and Basic UI",
            description = "Learning about Rows, Columns, and Boxes in Jetpack Compose.",
            category = "UI Basics",
            date = "2024-03-01",
            featureNumber = 6,
            isCompleted = true
        ),
        Feature(
            id = "lesson_07",
            title = "Navigation in Compose",
            description = "Implementing type-safe navigation and passing arguments.",
            category = "Navigation",
            date = "2024-03-15",
            featureNumber = 7,
            isCompleted = false
        )
    )

    fun getMiniApps(): List<MiniApp> = listOf(
        MiniApp(
            id = "coffee_shop",
            title = "Coffee Shop UI",
            description = "A multi-screen UI for a fictional coffee shop app.",
            category = "UI Challenge",
            date = "2024-04-01",
            projectType = "Full UI Design"
        ),
        MiniApp(
            id = "login_flow",
            title = "Firebase Login Flow",
            description = "Complete authentication flow with email/password and social login.",
            category = "Mini App",
            date = "2024-04-20",
            projectType = "Functionality Demo"
        )
    )

    fun getFeatureById(id: String): Feature? = getFeatures().find { it.id == id }
    fun getMiniAppById(id: String): MiniApp? = getMiniApps().find { it.id == id }
}
