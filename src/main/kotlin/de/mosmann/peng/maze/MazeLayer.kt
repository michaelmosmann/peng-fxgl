package de.mosmann.peng.maze

import com.almasb.fxgl.dsl.FXGL
import com.almasb.fxgl.entity.Entity
import de.mosmann.peng.Maze
import de.mosmann.peng.MazePosition
import de.mosmann.peng.Playfield

class MazeLayer(entities: List<Entity>) {
    companion object {
        fun create(playfield: Playfield, maze: Maze, gridSize: Int): MazeLayer {
            var walls = emptyList<Entity>()

            val allColumns: IntRange = 0 until maze.columns
            allColumns.forEach { col ->
                maze.rows.forEachIndexed { row, s ->
                    if (maze.isWall(MazePosition(col, row))) {
                        walls = walls + FXGL.entityBuilder()
                            .at(col*gridSize*1.0, row*gridSize*1.0)
                            .viewWithBBox("wall.png")
                            .buildAndAttach()
                    }
                }
            }

            return MazeLayer(walls)
        }
    }
}