package com.boxandabs.app

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CalculatorTest {
    @Test
    fun testAddition() {
        assertEquals(5.0, Calculator.add(2.0, 3.0))
    }

    @Test
    fun testSubtraction() {
        assertEquals(1.0, Calculator.subtract(4.0, 3.0))
    }

    @Test
    fun testMultiplication() {
        assertEquals(6.0, Calculator.multiply(2.0, 3.0))
    }

    @Test
    fun testDivision() {
        assertEquals(2.0, Calculator.divide(6.0, 3.0))
    }

    @Test
    fun testDivisionByZeroThrows() {
        assertFailsWith<IllegalArgumentException> { Calculator.divide(1.0, 0.0) }
    }
}
