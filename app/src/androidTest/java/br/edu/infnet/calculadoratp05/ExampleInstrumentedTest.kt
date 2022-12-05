package br.edu.infnet.calculadoratp05

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class InstrumentedTest {
    @JvmField
    @Rule
    var activityActivityTestRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun inputOnePlusOneExpression() {
        // 1 + 1 = 2
        onView(withId(R.id.btn1)).perform(click())
        onView(withId(R.id.btn_soma)).perform(click())
        onView(withId(R.id.btn1)).perform(click())
        onView(withId(R.id.btn_igual)).perform(click())

    }

    @Test
    fun inputOneLessOneExpression() {
        // 1 - 1 = 0
        onView(withId(R.id.btn1)).perform(click())
        onView(withId(R.id.btn_subtracao)).perform(click())
        onView(withId(R.id.btn1)).perform(click())
        onView(withId(R.id.btn_igual)).perform(click())

    }

    @Test
    fun inputFiveMultipliedByTwoExpression() {
        // 5 x 2 = 10
        onView(withId(R.id.btn5)).perform(click())
        onView(withId(R.id.btn_multiplicacao)).perform(click())
        onView(withId(R.id.btn2)).perform(click())
        onView(withId(R.id.btn_igual)).perform(click())

    }

    @Test
    fun inputTenDividedByTwoExpression() {
        // 10 / 2 = 5
        onView(withId(R.id.btn1)).perform(click())
        onView(withId(R.id.btn0)).perform(click())
        onView(withId(R.id.btn_divisao)).perform(click())
        onView(withId(R.id.btn2)).perform(click())
        onView(withId(R.id.btn_igual)).perform(click())

    }

    @Test
    fun inputCleanAll() {
        // 10203 ->
        onView(withId(R.id.btn1)).perform(click())
        onView(withId(R.id.btn0)).perform(click())
        onView(withId(R.id.btn2)).perform(click())
        onView(withId(R.id.btn0)).perform(click())
        onView(withId(R.id.btn3)).perform(click())
        onView(withId(R.id.btn_limpar)).perform(click())

    }

    @Test
    fun inputMultiplicationByDecimal() {
        // 100.5 x 2 = 201
        onView(withId(R.id.btn1)).perform(click())
        onView(withId(R.id.btn0)).perform(click())
        onView(withId(R.id.btn0)).perform(click())
        onView(withId(R.id.btn_ponto)).perform(click())
        onView(withId(R.id.btn5)).perform(click())
        onView(withId(R.id.btn_multiplicacao)).perform(click())
        onView(withId(R.id.btn2)).perform(click())
        onView(withId(R.id.btn_igual)).perform(click())

    }

}


