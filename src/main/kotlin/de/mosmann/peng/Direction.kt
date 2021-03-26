package de.mosmann.peng

enum class Direction {
    Left, Right, Up, Down;

    fun mazeDirections(): List<Direction> {
        return when (this) {
            Left -> listOf(Left,Up,Right,Down)
            Up -> listOf(Up,Right,Down,Left)
            Right -> listOf(Right,Down,Left,Up)
            Down -> listOf(Down,Left,Up,Right)
        }
    }

    fun oppositeDirection(): Direction {
        return when(this) {
            Left -> Right
            Right -> Left
            Up -> Down
            Down -> Up
        }
    }

    fun notOppositeOf(other: Direction): Boolean {
        return oppositeDirection()!=other
    }
}