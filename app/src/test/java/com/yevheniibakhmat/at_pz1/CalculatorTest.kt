package com.yevheniibakhmat.at_pz1

import junit.framework.TestCase.*
import org.junit.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun shouldReturnCorrectIntResult() {
        val result = calculator.evaluate("1+2*3")
        assertEquals(7.0, result,0.0001)
    }

    @Test
    fun shouldReturnCorrectDoubleResult() {
        val result = calculator.evaluate("12*0.3+2")
        assertEquals(5.6, result,0.0001)
    }

    @Test
    fun shouldReturnCorrectWhenStartsWithMinus() {
        val result = calculator.evaluate("-12*0.3+2")
        assertEquals(-1.6, result, 0.0001)
    }

}