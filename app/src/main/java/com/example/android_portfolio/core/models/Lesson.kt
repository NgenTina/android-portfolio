package com.example.android_portfolio.data.models

data class Lesson(
    override val id: String,
    override val title: String,
    override val description: String,
    override val category: String,
    override val date: String,
    val lessonNumber: Int,
    val homeworkCompleted: Boolean = false
) : ProjectItem
