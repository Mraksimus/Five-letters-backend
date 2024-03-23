package dev.mraksimus.infrastructure.repositories.game.session

import dev.mraksimus.compat.SerialUUID
import dev.mraksimus.infrastructure.dto.Game
import dev.mraksimus.infrastructure.dto.GameSession

interface GameSessionRepository {

    fun create(dto: GameSession): GameSession

    fun update(
        id: SerialUUID,
        dto: GameSession
    ): Int

    fun findLast(gameId: SerialUUID): GameSession

}