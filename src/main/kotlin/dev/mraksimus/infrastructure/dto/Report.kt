package dev.mraksimus.infrastructure.dto

import dev.mraksimus.compat.SerialUUID
import kotlinx.serialization.Serializable

@Serializable
data class Report(
    val id: SerialUUID,
    val userId: SerialUUID,
    val wordId: SerialUUID
)
