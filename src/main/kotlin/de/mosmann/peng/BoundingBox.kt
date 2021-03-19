package de.mosmann.peng

class BoundingBox(val x: Int, val y: Int, val w: Int, val h: Int) {

    val xRange = Range(x,w)
    val yRange = Range(y,h)

    companion object {
        @JvmStatic
        fun main(vararg param: String) {
            val box1 = BoundingBox(0,0,10,20)
            val box2 = BoundingBox(9,19,2,2)
            val hit = box1.intersect(box2)
            if (hit) {
                println("Hit!!!!")
            }
        }
    }

    private fun intersect(box2: BoundingBox): Boolean {
        return this.xRange.intersec(box2.xRange)
                && this.yRange.intersec(box2.yRange)
    }
}