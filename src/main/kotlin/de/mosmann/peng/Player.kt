package de.mosmann.peng

import com.almasb.fxgl.core.math.Vec2
import com.almasb.fxgl.dsl.FXGL
import com.almasb.fxgl.dsl.components.EffectComponent
import com.almasb.fxgl.entity.component.Component
import com.almasb.fxglgames.drop.DropApp

class Player(val playfield: Playfield) : Component() {

    private var speed = 200.0
    private var direction: Direction? = null

    override fun onUpdate(tpf: Double) {
        var velocity = Vec2()

        if (direction!=null) {
            when (direction) {
                Direction.Left -> velocity.x = -1f
                Direction.Right -> velocity.x = 1f
                Direction.Up -> velocity.y = -1f
                Direction.Down -> velocity.y = 1f
            }
        }

        if (velocity.length() > 0) {
            velocity = velocity.normalize().mul(speed)
        }

        entity.x = playfield.clampX(entity.x + velocity.x * tpf)
        entity.y = playfield.clampY(entity.y + velocity.y * tpf)


        direction = null
    }

    fun move(direction: Direction?) {
        this.direction = direction;
    }

    companion object {
        fun create(playfield: Playfield): Player {
            val entity = FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .at(0.0,0.0)
                .viewWithBBox("player.png")
                .collidable()
                .with(Player(playfield), EffectComponent())
                .buildAndAttach()

            return entity.getComponent(Player::class.java)
        }
    }
}