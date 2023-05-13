package io.github.tuguzd.gamegenbulb.util

import org.junit.runner.Description
import org.junit.runner.manipulation.Ordering
import org.junit.runner.manipulation.Sorter

/**
 * Order test methods by their [Order] annotation. The lower value has the highest priority.
 * The tests that are not annotated get the default value of 0.
 */
class OrderAnnotation : Sorter(COMPARATOR), Ordering.Factory {
    override fun create(context: Context): Ordering = this

    companion object {
        private val COMPARATOR = Comparator.comparingInt { description: Description ->
            description.getAnnotation(Order::class.java)?.value ?: 0
        }
    }
}
