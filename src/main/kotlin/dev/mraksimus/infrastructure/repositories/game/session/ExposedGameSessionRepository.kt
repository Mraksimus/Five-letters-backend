package dev.mraksimus.infrastructure.repositories.game.session

import dev.mraksimus.compat.SerialUUID
import dev.mraksimus.extensions.updateById
import dev.mraksimus.infrastructure.dto.Game
import dev.mraksimus.infrastructure.dto.GameSession
import dev.mraksimus.infrastructure.models.GameModel
import dev.mraksimus.infrastructure.models.GameSessionModel
import dev.mraksimus.plugins.json
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.json.jsonb

class ExposedGameSessionRepository : GameSessionRepository {

    override fun create(dto: GameSession): GameSession {

        val wordsJson = Json.encodeToString(dto.words)

        val insertedRow = GameSessionModel.insert {
            it[id] = SerialUUID.randomUUID()
            it[gameId] = dto.gameId
            it[wordId] = dto.wordId
            it[words] = dto.words.last() //??
            it[attempts] = dto.attempts
            it[createdAt] = dto.createdAt
            it[type] = dto.type
        }

        return dto.copy(id = insertedRow[GameSessionModel.id].value)
    }

    override fun update(
        id: SerialUUID,
        dto: GameSession
    ): Int {
        return GameSessionModel.updateById(id) {
            it[gameId] = dto.gameId
            it[wordId] = dto.wordId
            it[words] = dto.words.last() //??
            it[attempts] = dto.attempts
            it[createdAt] = dto.createdAt
            it[type] = dto.type
        }
    }

    override fun findLast(gameId: SerialUUID): GameSession? {
        return GameSessionModel
            .selectAll()
            .orderBy(GameSessionModel.createdAt to SortOrder.ASC)
            .where(GameSessionModel.gameId eq gameId)
            .firstOrNull()
            ?.
    }

}