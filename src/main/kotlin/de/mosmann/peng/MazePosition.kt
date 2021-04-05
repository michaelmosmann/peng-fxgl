package de.mosmann.peng

data class MazePosition(val column: Int, val row: Int) {
    fun nextPositionInto(direction: Direction): MazePosition {
        return when(direction) {
            Direction.Right -> MazePosition(column+1,row)
            Direction.Left -> MazePosition(column-1,row)
            Direction.Up -> MazePosition(column,row-1)
            Direction.Down -> MazePosition(column,row+1)
        }
    }
}