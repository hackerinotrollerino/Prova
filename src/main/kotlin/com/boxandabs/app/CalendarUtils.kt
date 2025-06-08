package com.boxandabs.app

import java.util.Calendar

data class CalendarDay(
    val day: Int,
    val status: String,
    val isCurrentMonth: Boolean
)

fun generateCalendarDays(now: Calendar = Calendar.getInstance()): List<CalendarDay> {
    val calendar = now.clone() as Calendar
    val today = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.set(Calendar.DAY_OF_MONTH, 1)
    val firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1
    val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

    val days = mutableListOf<CalendarDay>()
    repeat(firstDayOfMonth) {
        days.add(CalendarDay(0, "", false))
    }
    for (day in 1..daysInMonth) {
        val status = when {
            day < today -> listOf("done", "skipped", "rest").random()
            day == today -> "today"
            else -> "upcoming"
        }
        days.add(CalendarDay(day, status, true))
    }
    return days
}

/**
 * Counts how many days in the given list are marked with status "done".
 */
fun countCompletedDays(days: List<CalendarDay>): Int {
    return days.count { it.status == "done" }
}

/**
 * Calculates the longest streak of consecutive days with status "done".
 */
fun longestStreak(days: List<CalendarDay>): Int {
    var maxStreak = 0
    var currentStreak = 0
    for (day in days) {
        if (day.status == "done") {
            currentStreak++
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak
            }
        } else {
            currentStreak = 0
        }
    }
    return maxStreak
}
