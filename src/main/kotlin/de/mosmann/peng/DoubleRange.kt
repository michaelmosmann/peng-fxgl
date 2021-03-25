package de.mosmann.peng

class DoubleRange(val start: Double, val length: Double) {

    fun intersec(other: DoubleRange): Boolean {
        val end = start + length
        val otherEnd = other.start + other.length

        // 0 <= 19 && 19 < (0+20) --> drin
        // 0 <= 20 && 20 < (0+20) --> nicht drin

        // 1 <= 20 && 20 < (1+20) --> drin
        // 1 <= 21 && 21 < (1+20) --> nicht drin

        // 0 <= 19.9999 && 19.9999 < (0+20.0000) -> drin
        // 0 <= 20.0000 && 20.0000 < (0+20.0000) --> nicht drin

        // 0 <= 19 && 19 < (0+20) -> drin
        // 0 <= 20 && 20 < (0+20) --> nicht drin

        if (between(start, other.start, end)) return true
        if (between(start, otherEnd, end)) return true

        return false
    }

    companion object {
        fun between(start: Double, between: Double, endExclusive: Double): Boolean {
            return start <= between && between < endExclusive
        }

        fun of(start: Double, end: Double): DoubleRange {
            return DoubleRange(start, end - start)
        }
    }
}