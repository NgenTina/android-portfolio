package com.example.android_portfolio.navigation

/**
 * Type-safe route definitions for navigation.
 *
 * Using a sealed class instead of raw strings prevents typos,
 * makes routes discoverable via autocomplete, and ensures
 * compile-time safety when navigating between screens.
 */
sealed class Screen(val route: String) {

    // ── Main Hubs ──
    object Home : Screen("home")
    object LessonsHub : Screen("lessons_hub")
    object PracticeHub : Screen("practice_hub")

    // ── Lessons ──
    object AppBars : Screen("app_bars")
    object ComposeBasics : Screen("lesson_compose_basics")
    object StateManagement : Screen("lesson_state")
    object NavigationLesson : Screen("lesson_navigation")

    // ── Practice ──
    object Recipes : Screen("recipe_ui")
    object DateTimePicker : Screen("date_picker_ui")
}
