package dev.mraksimus.infrastructure.repositories.game

import dev.mraksimus.compat.SerialUUID
import dev.mraksimus.extensions.updateById
import dev.mraksimus.infrastructure.dto.Game
import dev.mraksimus.infrastructure.models.GameModel
import dev.mraksimus.infrastructure.models.WordModel
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class ExposedGameRepository : GameRepository {

    override fun create(dto: Game): Game {

        val insertedRow = GameModel.insert {
            it[id] = SerialUUID.randomUUID()
            it[userId] = dto.userId
            it[score] = dto.score
            it[lives] = dto.lives
            it[state] = dto.state
        }

        return dto.copy(id = insertedRow[GameModel.id].value)
    }

    override fun update(
        id: SerialUUID,
        dto: Game
    ): Int {
        return GameModel.updateById(id) {
            it[userId] = dto.userId
            it[score] = dto.score
            it[lives] = dto.lives
            it[state] = dto.state
        }
    }

    override fun find(id: SerialUUID): Game? {
        return GameModel
            .selectAll()
            .where (GameModel.id eq id)
            .firstOrNull()
            ?.toGameDto()
    }

    override fun findActive(userId: SerialUUID): Game? {
        return GameModel
            .selectAll()
            .where((GameModel.state eq Game.State.OPEN) and (GameModel.userId eq userId))
            .firstOrNull()
            ?.toGameDto()
    }

    private fun ResultRow.toGameDto() = Game(
        id = this[GameModel.id].value,
        userId = this[GameModel.userId].value,
        score = this[GameModel.score],
        lives = this[GameModel.lives],
        state = this[GameModel.state]
    )

}