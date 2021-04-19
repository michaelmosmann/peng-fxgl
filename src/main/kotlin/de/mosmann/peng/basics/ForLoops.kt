package de.mosmann.peng.basics

object ForLoops {

    // Hinweis: wenn ich in kotlin neue Variablen definere
    // schreibe ich
    //   val variablenName
    // wenn die Variable einmal zugewiesen wird und sich danach
    // nicht mehr ändert.
    // Wenn sich der Wert einer Variablen ändern soll, dann schreibe ich
    //  var variablenName
    // val->value(Wert, meint hier unveränderlich)
    // var->variable(meint hier veränderlich)
    // das ist noch etwas verwirrend, man gewöhnt sich aber dran

    fun sumOfNumbers(start: Int, end: Int): Int {
        // addiere alle Zahlen von start bis end (inkl. end)



        // wie bei der Funktion, wo wir aus hallo h_a_l_l_o gemacht haben,
        // könnte man das als Ablaufplan wie folgt darstellen:
        //  sum = sum + start
        //  sum = sum + (start+1)
        //  ...
        //  sum = sum + end
        // Das musst du jetzt nur mit einer for-schleife lösen


        // for (kannstDuNennenWieDuWillst in ?..?) {
        //  ??
        // }

        var summe = 0


        val alleZahlen: IntRange = start..end
        //for (eineZahl in alleZahlen){
        //  summe = summe + eineZahl
        //}

//        for (eineZahl in start until end + 1 step 1){
//            summe = summe + eineZahl
//        }

        var eineZahl = start // wir legen einen Startwert fest
        while (eineZahl<=end == true) { // prüfen wir, ob wir den block {} ausführen müssen
            // wir addieren zu dem letzen Wert von
            // summe eineZahl hinzu und weisen den neuen Wert der Variablen mit dem Namen summe zu.
            val neueSumme = summe + eineZahl
            summe = neueSumme

            val naechsteZahl = eineZahl + 1
            eineZahl=naechsteZahl
        }



        return summe
    }

    fun sumOfNumbersWithoutEnd(start: Int, end: Int): Int {
        // addiere alle Zahlen von start bis end (OHNE end)
        // dazu musst du fast den selben Code wie oben schreiben
        // mit dem kleinen Unterschied, das wir wie in
        // BasicTasks.putSpacerBetweenEachChar die letzte Ausführung
        // der schleife verhindern müssen(da gibt es mehr als eine Lösung,
        // wähle die, auf die Du als erstes kommst)

        var summe = 0

        var eineZahl = start // 10
        while (eineZahl<end == true) {
            summe = summe + eineZahl

            eineZahl=eineZahl+1
        }

//        for (int eineZahl=start; eineZahl<end; eineZahl=eineZahl+1) {
//
//        }
//        for (eineZahl in start until end step 1){
//            summe = summe + eineZahl
//        }

//        for (eineZahl in start..(end-1)) {
//            summe = summe + eineZahl
//        }


        return summe
    }
}