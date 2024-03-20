package dev.mraksimus.infrastructure.models

import dev.mraksimus.infrastructure.dto.User
import dev.mraksimus.plugins.json
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.json.jsonb
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object UserModel : UUIDTable("users") {

    val index = varchar("index", 20).uniqueIndex()
    val profile = jsonb<User.Profile>("profile", json)
    val createdAt = datetime("created_at")

}