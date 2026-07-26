package com.example.android_portfolio.data.repository

import com.example.android_portfolio.data.models.Lesson
import com.example.android_portfolio.data.models.PracticeItem

object ProjectRepository {
    fun getLessons(): List<Lesson> = listOf(
        Lesson(
            id = "lesson_06",
            title = "Layouts and Basic UI",
            description = "Learning about Rows, Columns, and Boxes in Jetpack Compose.",
            category = "UI Basics",
            date = "2024-03-01",
            lessonNumber = 6,
            homeworkCompleted = true
        ),
        Lesson(
            id = "lesson_07",
            title = "Navigation in Compose",
            description = "Implementing type-safe navigation and passing arguments.",
            category = "Navigation",
            date = "2024-03-15",
            lessonNumber = 7,
            homeworkCompleted = false
        )
    )

    fun getPracticeItems(): List<PracticeItem> = listOf(
        PracticeItem(
            id = "coffee_shop",
            title = "Coffee Shop UI",
            description = "A multi-screen UI for a fictional coffee shop app.",
            category = "UI Challenge",
            date = "2024-04-01",
            projectType = "Full UI Design"
        ),
        PracticeItem(
            id = "login_flow",
            title = "Firebase Login Flow",
            description = "Complete authentication flow with email/password and social login.",
            category = "Mini App",
            date = "2024-04-20",
            projectType = "Functionality Demo"
        )
    )

    fun getLessonById(id: String): Lesson? = getLessons().find { it.id == id }
    fun getPracticeItemById(id: String): PracticeItem? = getPracticeItems().find { it.id == id }
}
