package io.github.tuguzd.gamegenbulb.util

/**
 * JUnit 4 equivalent of JUnit 5's `org.junit.jupiter.api.Order`
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
)
annotation class Order(
    /**
     * The order value for the annotated element.
     *
     * Elements are ordered based on priority where a lower value has greater
     * priority than a higher value. For example, [Integer.MAX_VALUE] has
     * the lowest priority.
     */
    val value: Int = 0,
)
