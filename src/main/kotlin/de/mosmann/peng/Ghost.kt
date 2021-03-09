package de.mosmann.peng

import com.almasb.fxgl.core.math.Vec2
import com.almasb.fxgl.dsl.FXGL
import com.almasb.fxgl.dsl.components.EffectComponent
import com.almasb.fxgl.entity.component.Component
import java.util.concurrent.ThreadLocalRandom

class Ghost(val playfield: Playfield) : Component() {

    private var speed = 200.0
    private var direction: Direction = Direction.Right
    private var runtime: Double = 0.0

    override fun onUpdate(delta: Double) {
        var velocity = Vec2()
        velocity.x = 0f
        velocity.y = 0f

        when (direction) {
            Direction.Left ->
                velocity.x = -1f
            Direction.Right ->
                velocity.x = 1f
            Direction.Up ->
                velocity.y = -1f
            Direction.Down ->
                velocity.y = 1f
        }

        if (velocity.length() > 0) {
            velocity = velocity.normalize().mul(speed)
        }

        val newX = entity.x + velocity.x * delta
        val newY = entity.y + velocity.y * delta

        entity.x = playfield.clampX(newX)
        entity.y = playfield.clampY(newY)

        val hitTheWall = newX != entity.x || newY != entity.y
        if (hitTheWall) {
            direction = when (direction) {
                Direction.Left ->
                    Direction.Up
                Direction.Up ->
                    Direction.Right
                Direction.Right ->
                    Direction.Down
                Direction.Down ->
                    Direction.Left
            }
        }

        runtime = runtime + delta
        if (runtime > 1) {
            runtime = 0.0
            val zufall = ThreadLocalRandom.current().nextInt(0,4)
            direction = when (zufall) {
                0 ->
                    Direction.Up
                1 ->
                    Direction.Right
                2 ->
                    Direction.Down
                3 ->
                    Direction.Left
                else ->
                    throw IllegalArgumentException("should not happen")
            }
        }
    }

    fun moveTo(x: Double, y: Double): Ghost {
        entity.x = x
        entity.y = y
        return this
    }



    

    companion object {
        fun create(playfield: Playfield): Ghost {
            val entity = FXGL.entityBuilder()
                .type(EntityType.GHOST)
                .at(0.0, 0.0)
                .viewWithBBox("ghost.png")
                .collidable()
                .with(Ghost(playfield), EffectComponent())
                .buildAndAttach()

            return entity.getComponent(Ghost::class.java)
        }
    }
}