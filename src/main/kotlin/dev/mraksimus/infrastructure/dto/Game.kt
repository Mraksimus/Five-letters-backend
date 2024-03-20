package dev.mraksimus.infrastructure.dto

import dev.mraksimus.compat.SerialUUID
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val userId: SerialUUID,
    val lives: Short,
    val score: Int
)
