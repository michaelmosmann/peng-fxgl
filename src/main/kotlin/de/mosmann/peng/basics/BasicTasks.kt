package de.mosmann.peng.basics

import java.lang.StringBuilder

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
        val max = if (number > otherNumber) number else otherNumber
        return max
    }

    fun firstCharacter(text: String): Char {
        // gebe den ersten Buchstaben zurück
        // in den meisten Programmiersprachen fängt man
        // bei 0 zu zählen an, und nicht bei 1

        // in Kotlin kann man bei den meisten Typen/Klassen
        // die eine Reihe von Werten beinhalten über eine
        // get()-Funktion auf einen Wert mit einem Index zugreifen
        // folgende Schreibweisen sind dabei gleichbedeutend
        // variable.get(index) == variable[index]
        return text.get(0)
    }

    fun firstEntry(numbers: Array<Int>): Int {
        // das Prinzip ist hier das selbe wie bei firstCharacter
        return numbers.get(0)
    }

    fun lastCharacter(text: String): Char {
        // das letzte Zeichen in dem String zurück geben
        // Hinweis: die Zählung beginnt bei 0
        // Beispiel: das letzte Zeichen von 'Hallo' ist 'o', die Länge ist 5,
        // der Buchstabe an Index=0 ist H
        val len = text.length
        return text.get(text.length -1)
    }

    fun longestString(text: String, otherText: String): String {
        // gebe den String zurück, der länger ist
        // ist so ähnlich wie die max()-Funktion,
        // nur das du hier den Wert selbst, sondern eine Eigenschaft
        // des Wertes (die Länge) vergleichst
        val longestString = if (text > otherText) text else otherText
        return longestString
    }

    fun numberListAsString(max: Int): String {
        // diese Funktion erzeugt für eine Zahl max einen
        // String, der z.B. für max=3 wie folgt aussieht
        // 0,1,2,3,
        // das soll als Anregung dienen, wie du die Funktion drunter
        // vielleicht implementieren könntest
        // die Klasse StringBuilder ist eine Hilfsklasse zum zusammenbauen
        // von Strings
        val sb=StringBuilder()

        for (i in 0..max) {
            sb.append(i).append(",")
        }

        return sb.toString()
    }

    fun putSpacerBetweenEachChar(text: String, spacer: Char): String {
        // diese Funktion soll zwischen jeden Buchstaben in einem Text ein
        // Zeichen dazwischen packen
        // wenn text="hallo" und spacer='-' ist, sollte das Ergebnis
        // h-a-l-l-o-
        // sein
        val sb=StringBuilder()

        val lastPosition = text.length - 1

        for (i in 0..lastPosition) {
            sb.append(text.get(i))
            if(i != lastPosition) {
                sb.append(spacer)
            }
        }

        return sb.toString()
    }
}