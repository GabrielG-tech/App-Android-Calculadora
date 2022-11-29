package br.edu.infnet.calculadoratp03


import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**  Example local unit test, which will execute on the development machine (host).
  See [testing documentation](http://d.android.com/tools/testing). */

@RunWith(JUnit4::class)
class ExampleUnitTest {
    // @JvmField
    @Rule
    // var activityActivityTestRule = ActivityScenarioRule<MainActivity>(MainActivity)

    @Test
    fun add(){
        assertEquals(4, 2 + 2)
    }

}