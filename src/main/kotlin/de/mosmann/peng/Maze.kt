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
        return TODO("Not yet implemented")
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