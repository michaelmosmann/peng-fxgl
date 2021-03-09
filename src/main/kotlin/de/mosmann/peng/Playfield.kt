package de.mosmann.peng

class Playfield(val width: Double, val heigth: Double) {
    fun clampX(value: Double): Double {
        if (value<0) return 0.0
        if (value>width) return width
        return value
    }

    fun clampY(value: Double): Double {
        if (value<0) return 0.0
        if (value>heigth) return heigth
        return value
    }
}