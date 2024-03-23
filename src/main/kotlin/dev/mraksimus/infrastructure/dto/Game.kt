package dev.mraksimus.infrastructure.dto

import dev.mraksimus.compat.SerialUUID
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val id: SerialUUID,
    val userId: SerialUUID,
    val score: Int,
    val lives: Short,
    val state: State
) {
    enum class State {
        OPEN,
        CLOSED
    }
}
