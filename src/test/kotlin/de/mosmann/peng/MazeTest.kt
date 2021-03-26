package de.mosmann.peng

import org.assertj.core.api.Assertions.assertThat
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
                    "|         |\n" +
                    "+---------+"
        )

        println(maze)

        val type: Maze.Field = maze.whatIsAt(MazePosition(0,0))

        assertThat(type).isEqualTo(Maze.Field.Corner)

        val walkToRightPossible: Boolean = maze.canIWalkTo(MazePosition(0,0),Direction.Right)

        assertThat(walkToRightPossible).isFalse()

        assertThat(maze.canIWalkTo(MazePosition(0,1), Direction.Right)).isTrue
        assertThat(maze.canIWalkTo(MazePosition(1,1), Direction.Down)).isTrue

        val start=MazePosition(1,1)
        var currentDirection = Direction.Right

        var current = start

        val maxLoops = 100;
        var loops=0;

        do {
            loops++
            if (loops>maxLoops) throw IllegalArgumentException("something went wrong")
            println("current: $current - $currentDirection")
            showPosition(maze, current)

            val mazeDirections = currentDirection.mazeDirections()

            val walkableDirections = mazeDirections.filter { direction ->
                maze.canIWalkTo(current, direction)
            }

            if (walkableDirections.size>1) {
                currentDirection = walkableDirections.first { it.notOppositeOf(currentDirection) }
            } else {
                currentDirection = walkableDirections[0]
            }
            current = current.next(currentDirection)

        } while (current!=start)
        
        println("current: $current - $currentDirection")
    }

    fun showPosition(maze: Maze, position: MazePosition) {
        val sb=StringBuilder()
        maze.rows.forEachIndexed { r, row ->
            row.columns.forEachIndexed { c, field ->
                if (MazePosition(c,r)==position) {
                    sb.append("*")
                } else {
                    sb.append(field.char)
                }
            }
            sb.append("\n")
        }

        println(sb)
    }
}