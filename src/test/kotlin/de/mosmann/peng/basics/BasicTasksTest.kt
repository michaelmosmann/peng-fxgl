package de.mosmann.peng.basics

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BasicTasksTest {

    @Test
    fun checkAddFunction() {
        assertThat(BasicTasks.add(1,2)).isEqualTo(3)
        assertThat(BasicTasks.add(6,1)).isEqualTo(7)
    }

    @Test
    fun checkMinFunction() {
        assertThat(BasicTasks.min(1,2)).isEqualTo(1)
        assertThat(BasicTasks.min(6,1)).isEqualTo(1)
    }

    @Test
    fun checkMaxFunction() {
        assertThat(BasicTasks.max(1,2)).isEqualTo(2)
        assertThat(BasicTasks.max(6,1)).isEqualTo(6)
    }

    @Test
    fun checkFirstCharFunction() {
        assertThat(BasicTasks.firstCharacter("Klaus")).isEqualTo('K')
        assertThat(BasicTasks.firstCharacter("Susi")).isEqualTo('S')
    }

    @Test
    fun checkFirstEntryFunction() {
        assertThat(BasicTasks.firstEntry(arrayOf(1,2,3))).isEqualTo(1)
        assertThat(BasicTasks.firstEntry(arrayOf(3,3,3))).isEqualTo(3)
    }

    @Test
    fun checkLastCharFunction() {
        assertThat(BasicTasks.lastCharacter("Klaus")).isEqualTo('s')
        assertThat(BasicTasks.lastCharacter("Susi")).isEqualTo('i')
    }

    @Test
    fun checkLongestStringFunction() {
        assertThat(BasicTasks.longestString("hi","hoo")).isEqualTo("hoo")
        assertThat(BasicTasks.longestString("what","now")).isEqualTo("what")
    }
}
