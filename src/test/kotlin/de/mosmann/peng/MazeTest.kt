package de.mosmann.peng

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class MazeTest {

    @Test
    fun rowsOfMazeShouldSplitOnEachNewLine() {
        val result =Maze.rowsOfMazeString("foo\nbar\nbaz")
        assertThat(result).containsExactly("foo","bar","baz")
    }

    @Test
    fun columnsOfRowsMustCountColumnsForEachRow() {
        val columns = Maze.columnsOfMaze(listOf("###","###"))
        assertThat(columns).isEqualTo(3)
    }

    @Test
    fun columnsOfRowsMustFailIfOneRowIsSmaller() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Maze.columnsOfMaze(listOf("###","##"))
        }
    }

    @Test
    fun columnsOfRowsMustFailIfOneRowIsBigger() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Maze.columnsOfMaze(listOf("###","###","####"))
        }
    }

    @Test
    fun createMaze() {
        val mazeAsString = "" +
                "###########\n" +
                "# # #     #\n" +
                "# #       #\n" +
                "# ###     #\n" +
                "#         #\n" +
                "###########"

        val maze = Maze.create(mazeAsString)

        assertThat(maze).isNotNull
    }

    val commonMaze = "" +
            "###########\n" +
            "# # #     #\n" +
            "# #       #\n" +
            "# ###     #\n" +
            "#         #\n" +
            "###########"

    @Test
    fun isWallAtZeroZero() {
        val maze = Maze.create(commonMaze)
        val isWall = maze.isWall(MazePosition(0,0))
        
        assertThat(isWall).isTrue
    }

    @Test
    fun isnotWallAtOneOne() {
        val maze = Maze.create(commonMaze)
        val isWall = maze.isWall(MazePosition(1,1))

        assertThat(isWall).isFalse
    }

    /**
     * Wir haben ja jetzt ne Funktion, die uns für eine Stelle sagen kann, ob da ne Wand ist.
     * Darauf aufbauend brauchen wir jetzt ne Funktion, die uns sagen kann, ob man von einer Position
     * in eine bestimmte Richtung laufen kann.
     */
    @Test
    fun directionsWeCanWalkAtOneOne(maze.canWalkInto(position, Direction.Down) {
        val maze = Maze.create(commonMaze)

        val position = MazePosition(1, 1)

        assertThat(maze.canWalkInto(position, Direction.Up)).isFalse
        assertThat(maze.canWalkInto(position, Direction.Right)).isFalse
        assertThat(maze.canWalkInto(position, Direction.Down)).isTrue
        assertThat(maze.canWalkInto(position, Direction.Left)).isFalse
    }
}