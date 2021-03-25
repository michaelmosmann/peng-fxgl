package de.mosmann.peng

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class DoubleRangeTest {
    @Test
    fun rangesIntersectIfStartIsSmallerThanEnd() {
        val a = DoubleRange(0.0,2.0)
        val b = DoubleRange(1.0,3.0)

        assertThat(a.intersec(b)).isTrue()
    }

    @Test
    fun rangesIntersectToo() {
        val a = DoubleRange(1.0,2.0)
        val b = DoubleRange(0.0,2.0)

        assertThat(a.intersec(b)).isTrue()
    }

    @Test
    fun rangesDontIntersect() {
        val a = DoubleRange.of(0.0,20.0)
        val b = DoubleRange.of(20.0,22.0)
        val c = DoubleRange.of(22.0,30.0)

        assertThat(a.intersec(b)).isFalse()
        assertThat(b.intersec(c)).isFalse()
    }

    @Test
    fun testeBeispiele() {
        istDrin(0.0,19.9999,20.0)
        istNichtDrin(0.0,20.0,20.0)

        // 0 <= 19 && 19 < (0+20) --> drin
        // 0 <= 20 && 20 < (0+20) --> nicht drin


        // 1 <= 20 && 20 < (1+20) --> drin
        // 1 <= 21 && 21 < (1+20) --> nicht drin

        // 0 <= 19.9999 && 19.9999 < (0+20.0000) -> drin
        // 0 <= 20.0000 && 20.0000 < (0+20.0000) --> nicht drin

        // 0 <= 19 && 19 < (0+20) -> drin
        // 0 <= 20 && 20 < (0+20) --> nicht drin
    }

    private fun istDrin(start: Double, wert: Double, endExclusive: Double) {
        assertThat(DoubleRange.between(start,wert,endExclusive)).isTrue()
    }

    private fun istNichtDrin(start: Double, wert: Double, endExclusive: Double) {
        assertThat(DoubleRange.between(start,wert,endExclusive)).isFalse()
    }
}