package de.mosmann.peng

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test


internal class RangeTest {
    @Test
    fun rangesIntersectIfStartIsSmallerThanEnd() {
        val a = Range(0,2)
        val b = Range(1,2)

        Assertions.assertThat(a.intersec(b)).isTrue()
    }
}