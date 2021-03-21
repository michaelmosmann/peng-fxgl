package de.mosmann.peng

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class RangeTest {
    @Test
    fun rangesIntersectIfStartIsSmallerThanEnd() {
        val a = Range(0,2)
        val b = Range(1,3)

        assertThat(a.intersec(b)).isTrue()
    }

    @Test
    fun rangesIntersectToo() {
        val a = Range(1,2)
        val b = Range(0,2)

        assertThat(a.intersec(b)).isTrue()
    }

    // what
}