package dev.mraksimus.infrastructure.models

import org.jetbrains.exposed.dao.id.UUIDTable

object WordModel : UUIDTable("words") {
    val value = varchar("value", 255)
}