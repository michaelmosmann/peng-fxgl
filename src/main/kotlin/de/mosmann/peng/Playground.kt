package de.mosmann.peng

object Playground {
    fun hello(name: String) {
        println("hello"+name)
    }

    @JvmStatic
    fun main(vararg params: String) {
        hello("Klaus")
    }
}