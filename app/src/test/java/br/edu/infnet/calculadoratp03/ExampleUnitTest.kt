package br.edu.infnet.calculadoratp03

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    
    // --------------
    
    private var mCalculadora: Calculadora? = null

    /**
     * Set up the environment for testing
     */
    @Before
    fun setUp() {
        mCalculadora = Calculadora()
    }

    /**
     * Test for simple addition
     */
    @Test
    fun addTwoNumbers() {
        val resultAdd = mCalculadora!!.add(1.0, 1.0)
        MatcherAssert.assertThat(resultAdd, CoreMatchers.`is`(CoreMatchers.equalTo(2.0)))
    }

    /**
     * Test for addition with a negative operand
     */
    @Test
    fun addTwoNumbersNegative() {
        val resultAdd = mCalculadora!!.add(-1.0, 2.0)
        MatcherAssert.assertThat(resultAdd, CoreMatchers.`is`(CoreMatchers.equalTo(1.0)))
    }

    /**
     * Test for addition where the result is negative
     */
    @Test
    fun addTwoNumbersWorksWithNegativeResult() {
        val resultAdd = mCalculadora!!.add(-1.0, -17.0)
        MatcherAssert.assertThat(resultAdd, CoreMatchers.`is`(CoreMatchers.equalTo(-18.0)))
    }

    /**
     * Test for floating-point addition
     */
    @Test
    fun addTwoNumbersFloats() {
        val resultAdd = mCalculadora!!.add(1.111, 1.111)
        MatcherAssert.assertThat(resultAdd, CoreMatchers.`is`(CoreMatchers.equalTo(2.222)))
    }

    /**
     * Test for especially large numbers
     */
    @Test
    fun addTwoNumbersBignums() {
        val resultAdd = mCalculadora!!.add(123456781.0, 111111111.0)
        MatcherAssert.assertThat(resultAdd, CoreMatchers.`is`(CoreMatchers.equalTo(234567892.0)))
    }

    /**
     * Test for simple subtraction
     */
    @Test
    fun subTwoNumbers() {
        val resultSub = mCalculadora!!.sub(1.0, 1.0)
        MatcherAssert.assertThat(resultSub, CoreMatchers.`is`(CoreMatchers.equalTo(0.0)))
    }

    /**
     * Test for simple subtraction with a negative result
     */
    @Test
    fun subWorksWithNegativeResult() {
        val resultSub = mCalculadora!!.sub(1.0, 17.0)
        MatcherAssert.assertThat(resultSub, CoreMatchers.`is`(CoreMatchers.equalTo(-16.0)))
    }

    /**
     * Test for simple division
     */
    @Test
    fun divTwoNumbers() {
        val resultDiv = mCalculadora!!.div(32.0, 2.0)
        MatcherAssert.assertThat(resultDiv, CoreMatchers.`is`(CoreMatchers.equalTo(16.0)))
    }

    /**
     * Test for divide by zero; must throw IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException::class)
    fun divDivideByZeroThrows() {
        mCalculadora!!.div(32.0, 0.0)
    }

    /**
     * Test for simple multiplication
     */
    @Test
    fun mulTwoNumbers() {
        val resultMul = mCalculadora!!.mul(32.0, 2.0)
        MatcherAssert.assertThat(resultMul, CoreMatchers.`is`(CoreMatchers.equalTo(64.0)))
    }
}