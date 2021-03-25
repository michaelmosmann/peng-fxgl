package de.mosmann.peng

import org.junit.jupiter.api.Test

class LanguageStuffTest {

    @Test
    fun testLambda() {
        foo(
            number = 2123,
            transformNumber = { first,second-> "$first:$second"}
        )
    }

    private fun foo(number: Int, transformNumber: (Int,Int) -> String) {
        val asString = transformNumber(number,number+1)
        println("foo called -> $asString")
    }

    private fun numberAsString(number: Int): String {
        return ">$number<"
    }
}