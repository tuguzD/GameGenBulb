package io.github.tuguzd.gamegenbulb

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import io.github.tuguzd.gamegenbulb.util.Order
import io.github.tuguzd.gamegenbulb.util.OrderAnnotation
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.OrderWith
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@OrderWith(OrderAnnotation::class)
class ExampleInstrumentedTest4 {
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
