package de.mosmann.peng

import com.almasb.fxgl.core.math.Vec2
import com.almasb.fxgl.dsl.FXGL
import com.almasb.fxgl.dsl.components.EffectComponent
import com.almasb.fxgl.entity.component.Component
import com.almasb.fxglgames.drop.DropApp

class Ghost(val playfield: Playfield) : Component() {

    private var speed = 200.0
    private var direction: Direction = Direction.Right

    override fun onUpdate(tpf: Double) {
        var velocity = Vec2()

        when (direction) {
            Direction.Left -> velocity.x = -1f
            Direction.Right -> velocity.x = 1f
            Direction.Up -> velocity.y = -1f
            Direction.Down -> velocity.y = 1f
        }

        if (velocity.length() > 0) {
            velocity = velocity.normalize().mul(speed)
        }

        val newX = entity.x + velocity.x * tpf
        val newY = entity.y + velocity.y * tpf

        entity.x = playfield.clampX(newX)
        entity.y = playfield.clampY(newY)

        if (newX!=entity.x || newY!=entity.y) {
            direction = when (direction) {
                Direction.Right -> Direction.Down
                Direction.Down -> Direction.Left
                Direction.Left -> Direction.Up
                Direction.Up -> Direction.Right
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
                .at(0.0,0.0)
                .viewWithBBox("ghost.png")
                .collidable()
                .with(Ghost(playfield), EffectComponent())
                .buildAndAttach()

            return entity.getComponent(Ghost::class.java)
        }
    }
}