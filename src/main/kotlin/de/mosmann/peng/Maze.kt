package de.mosmann.peng

/**
 * Wand: #
 * Nicht-Wand: ' '
 */
data class Maze(
    val rows: List<String>,
    val columns: Int
) {
    fun isWall(mazePosition: MazePosition): Boolean {
        val rowindex = mazePosition.row
        val row: String = rows.get(rowindex)
        val field: Char = row.get(mazePosition.column)
        return field == '#'
    }

    fun canWalkInto(mazePosition: MazePosition, direction: Direction): Boolean {
        // Hinweise:
        //   in der Klasse MazePosition gibt es schon eine Funktion,
        //   mit der wir eine neue MazePosition in der entsprechenden Richtung bekommen
        //   versuche mal herauszufinden, in welcher Reihenfolge Du etwas tun musst.
        //
        // Tipp: wenn du ausgehend von der aktuellen Position die neue Position ermittelst
        //   und dann nachsiehst, ob da ne Wand ist, sollte das eigentlich reichen

        val newMazePositionInDirection: MazePosition = mazePosition.nextPositionInto(direction)
        val isNewMazePositionAWall: Boolean = isWall(newMazePositionInDirection)
        return !isNewMazePositionAWall
    }

    companion object {
        internal fun rowsOfMazeString(maze: String): List<String> {
            return maze.split('\n')
        }

        internal fun columnsOfMaze(rows: List<String>): Int {
            val columns = rows.map { it.length }
                .maxOf { it }

            rows.forEach {
                require(it.length == columns) { "zeile hat die falsche länge: $it" }
            }

            return columns
        }

        fun create(fieldAsString: String): Maze {
            val rowsOfMaze = rowsOfMazeString(fieldAsString)
            val columns = columnsOfMaze(rowsOfMaze)

            return Maze(rowsOfMaze, columns)
        }
    }
}