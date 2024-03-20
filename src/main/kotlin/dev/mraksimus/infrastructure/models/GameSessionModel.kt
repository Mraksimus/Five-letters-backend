package dev.mraksimus.infrastructure.models

import dev.mraksimus.infrastructure.dto.GameSession
import dev.mraksimus.plugins.json
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.json.jsonb
import java.util.*

object GameSessionModel : IdTable<UUID>("game_sessions") {

    val gameId = reference("game_id", GameModel, onDelete = ReferenceOption.CASCADE)
    val wordId = reference("word_id", WordModel, onDelete = ReferenceOption.CASCADE)
    val session = jsonb<GameSession.Session>("session", json)

    override val id = gameId

}