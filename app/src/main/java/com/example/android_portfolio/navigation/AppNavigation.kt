package com.example.android_portfolio.navigation

import kotlinx.serialization.Serializable

// Root Graphs
@Serializable object HomeGraph
@Serializable object PracticeGraph
@Serializable object LessonsGraph

// Home Screens
@Serializable object HomeRoute

// Practice Screens
@Serializable object PracticeListRoute
@Serializable data class PracticeDetailRoute(val itemId: String)

// Lesson Screens
@Serializable object LessonListRoute
@Serializable data class LessonDetailRoute(val lessonId: String)
