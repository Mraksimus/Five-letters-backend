package dev.mraksimus.infrastructure.models

import dev.mraksimus.infrastructure.dto.Game
import dev.mraksimus.infrastructure.dto.GameSession
import dev.mraksimus.plugins.json
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.json.jsonb
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import java.util.*

object GameModel : UUIDTable("games") {

    val userId = reference("user_id", UserModel, onDelete = ReferenceOption.CASCADE)
    val score = integer("score")
    val lives = short("lives")
    val state = enumerationByName<Game.State>("state", 7)

}