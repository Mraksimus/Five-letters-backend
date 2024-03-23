package dev.mraksimus.infrastructure.models

import dev.mraksimus.infrastructure.dto.GameSession
import dev.mraksimus.plugins.json
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.json.jsonb
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import java.util.*

object GameSessionModel : UUIDTable("game_sessions") {

    val gameId = reference("game_id", GameModel, onDelete = ReferenceOption.CASCADE)
    val wordId = reference("word_id", WordModel, onDelete = ReferenceOption.CASCADE)
    val words = jsonb<GameSession.Word>("words", json)
    val attempts = short("attempts")
    val createdAt = datetime("created_at")
    val type = jsonb<GameSession.Type>("words", json)

}