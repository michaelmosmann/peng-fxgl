package de.mosmann.peng

import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.app.GameSettings
import com.almasb.fxgl.dsl.*
import de.mosmann.peng.maze.MazeLayer
import javafx.scene.input.KeyCode

class PengApp : GameApplication() {
    override fun initSettings(settings: GameSettings?) {
        // initialize common game / window settings.
        settings!!.title = "Peng"
        settings.version = "1.0"
        settings.width = 800
        settings.height = 600

        playfield = Playfield((settings.width - 64).toDouble(), (settings.height -64).toDouble())
    }

    private lateinit var playfield: Playfield
    private lateinit var playerComponent: Player

    private val maze = Maze.create("" +
            "###########\n" +
            "# # #     #\n" +
            "# #       #\n" +
            "# ###     #\n" +
            "#         #\n" +
            "###########")

    override fun initGame() {
        playerComponent = Player.create(playfield)

        val ghost = Ghost.create(playfield).moveTo(200.0,0.0)
        val ghost2 = Ghost.create(playfield).moveTo(100.0,50.0)

//        getPhysicsWorld().addCollisionHandler()

        playerComponent.addGhosts(ghost, ghost2)

        val mazeLayer = MazeLayer.create(playfield, maze, 64)
    }

    override fun initInput() {
        onKey(KeyCode.LEFT,"Move Left") {
            playerComponent.move(Direction.Left)
        }
        onKey(KeyCode.RIGHT, "Move Right") {
            playerComponent.move(Direction.Right)
        }
        onKey(KeyCode.UP, "Move Up") {
            playerComponent.move(Direction.Up)
        }
        onKey(KeyCode.DOWN, "Move Down") {
            playerComponent.move(Direction.Down)
        }
    }
    
}

