package io.github.tuguzd.gamegenbulb

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@TestMethodOrder(OrderAnnotation::class)
class ExampleInstrumentedTest5 {
    @Test
    @Order(1)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.github.tuguzd.gamegenbulb", appContext.packageName)
    }

    @Test
    @Order(2)
    fun useAppContext_2() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.github.tuguzd.gamegenbulb", appContext.packageName)
    }
}
