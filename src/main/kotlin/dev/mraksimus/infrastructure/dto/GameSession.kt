package dev.mraksimus.infrastructure.dto

import dev.mraksimus.compat.SerialUUID
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class GameSession(
    val id: SerialUUID? = null,
    val gameId: SerialUUID,
    val wordId: SerialUUID,
    val session: List<Session>
) {

    @Serializable
    data class Session(
        val word: List<Letter>,
        val createdAt: LocalDateTime
    ) {

        @Serializable
        data class Letter(
            val value: String,
            val state: State
        )

        enum class State {
            CORRECT,
            EXIST,
            INCORRECT
        }

    }

}
