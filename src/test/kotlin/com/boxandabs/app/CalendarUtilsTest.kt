package com.boxandabs.app

import java.util.Calendar
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CalendarUtilsTest {
    @Test
    fun testGenerateCalendarDaysSizeAndToday() {
        val now = Calendar.getInstance()
        val days = generateCalendarDays(now)

        val calendar = now.clone() as Calendar
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        val firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

        assertEquals(firstDayOfMonth + daysInMonth, days.size)

        val todayIndex = firstDayOfMonth + now.get(Calendar.DAY_OF_MONTH) - 1
        assertEquals("today", days[todayIndex].status)
        assertTrue(days[todayIndex].isCurrentMonth)
    }

    @Test
    fun testCountCompletedDays() {
        val days = listOf(
            CalendarDay(1, "done", true),
            CalendarDay(2, "done", true),
            CalendarDay(3, "skipped", true),
            CalendarDay(4, "done", true)
        )

        assertEquals(3, countCompletedDays(days))
    }

    @Test
    fun testLongestStreak() {
        val days = listOf(
            CalendarDay(1, "done", true),
            CalendarDay(2, "done", true),
            CalendarDay(3, "skipped", true),
            CalendarDay(4, "done", true),
            CalendarDay(5, "done", true),
            CalendarDay(6, "done", true),
            CalendarDay(7, "rest", true)
        )

        assertEquals(3, longestStreak(days))
    }
}
