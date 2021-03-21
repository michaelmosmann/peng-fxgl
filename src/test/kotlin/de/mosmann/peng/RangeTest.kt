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

    @Test
    fun rangesDontIntersect() {
        val a = Range(0,20)
        val b = Range(20,2)

        assertThat(a.intersec(b)).isFalse()
    }

    @Test
    fun testeBeispiele() {
        istDrin(0,19,20)
        istNichtDrin(0,20,20)

        // 0 <= 19 && 19 < (0+20) --> drin
        // 0 <= 20 && 20 < (0+20) --> nicht drin


        // 1 <= 20 && 20 < (1+20) --> drin
        // 1 <= 21 && 21 < (1+20) --> nicht drin

        // 0 <= 19.9999 && 19.9999 < (0+20.0000) -> drin
        // 0 <= 20.0000 && 20.0000 < (0+20.0000) --> nicht drin

        // 0 <= 19 && 19 < (0+20) -> drin
        // 0 <= 20 && 20 < (0+20) --> nicht drin
    }

    private fun istDrin(start: Int, wert: Int, endExclusive: Int) {
        assertThat(Range.between(start,wert,endExclusive)).isTrue()
    }

    private fun istNichtDrin(start: Int, wert: Int, endExclusive: Int) {
        assertThat(Range.between(start,wert,endExclusive)).isFalse()
    }
}