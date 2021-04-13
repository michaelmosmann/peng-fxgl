package de.mosmann.peng.basics

object BasicTasks {

    fun add(number: Int, otherNumber: Int): Int {
        // zwei nummern addieren und das Ergebnis zurückgeben
        return number + otherNumber
    }

    // Hier die Dokumentation von Sprachkonstrukten
    // die für die folgenden Aufgaben hilfreich sein könnten
    // -> https://kotlinlang.org/docs/control-flow.html

    fun min(number: Int, otherNumber: Int): Int {
        // zwei nummern vergleichen
        // die kleinere zurück geben
        val min = if (number > otherNumber) otherNumber else number
        return min
    }

    fun max(number: Int, otherNumber: Int): Int {
        // zwei nummern vergleichen
        // die größere zurück geben
        val max = if (number >otherNumber) number else otherNumber
        return max
    }

    fun firstCharacter(value: String): Char {
        // gebe den ersten Buchstaben zurück
        // in den meisten Programmiersprachen fängt man
        // bei 0 zu zählen an, und nicht bei 1

        // in Kotlin kann man bei den meisten Typen/Klassen
        // die eine Reihe von Werten beinhalten über eine
        // get()-Funktion auf einen Wert mit einem Index zugreifen
        // folgende Schreibweisen sind dabei gleichbedeutend
        // variable.get(index) == variable[index]
        return value.get(0)
    }

    fun firstEntry(value: Array<Int>): Int {
        // das Prinzip ist hier das selbe wie bei firstCharacter
        return value.get(0)
    }
}