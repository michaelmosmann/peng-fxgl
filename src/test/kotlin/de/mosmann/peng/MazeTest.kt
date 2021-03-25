package de.mosmann.peng

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MazeTest {

    @Test
    fun useMaze() {
        val maze = Maze.create(
            "" +
                    "+---------+\n" +
                    "| | |     |\n" +
                    "| |       |\n" +
                    "| +--     |\n" +
                    "+---------+"
        )

        println(maze)
    }
}