package de.mosmann.peng.basics

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ForLoopsTest {

    @Test
    fun checkSumOfNumbers() {
        assertThat(ForLoops.sumOfNumbers(1,3)).isEqualTo(6)
    }

    @Test
    fun checkSumOfNumbersWithoutEnd() {
        assertThat(ForLoops.sumOfNumbersWithoutEnd(1,4)).isEqualTo(6)
    }
}