package dev.mraksimus.infrastructure.models

import dev.mraksimus.infrastructure.dto.GameSession
import dev.mraksimus.plugins.json
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.json.jsonb

object ReportModel : UUIDTable("reports") {

    val userId = reference("user_id", UserModel, onDelete = ReferenceOption.CASCADE)
    val wordId = reference("word_id", WordModel, onDelete = ReferenceOption.CASCADE)

}