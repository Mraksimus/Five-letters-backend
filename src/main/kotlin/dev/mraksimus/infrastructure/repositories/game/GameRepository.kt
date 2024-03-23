package dev.mraksimus.infrastructure.repositories.game

import dev.mraksimus.compat.SerialUUID
import dev.mraksimus.infrastructure.dto.Game
import dev.mraksimus.infrastructure.dto.Word

interface GameRepository {

    fun create(dto: Game): Game

    fun update(
        id: SerialUUID,
        dto: Game
    ): Int

    fun find(id: SerialUUID): Game?

    fun findActive(userId: SerialUUID): Game?

}