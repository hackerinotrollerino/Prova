package com.boxandabs.app

/** Simple arithmetic calculator. */
object Calculator {
    /** Adds two numbers and returns the sum. */
    fun add(a: Double, b: Double): Double = a + b

    /** Subtracts b from a and returns the result. */
    fun subtract(a: Double, b: Double): Double = a - b

    /** Multiplies two numbers and returns the product. */
    fun multiply(a: Double, b: Double): Double = a * b

    /**
     * Divides a by b.
     * @throws IllegalArgumentException if b is zero.
     */
    fun divide(a: Double, b: Double): Double {
        require(b != 0.0) { "Cannot divide by zero" }
        return a / b
    }
}
