package dev.mraksimus.infrastructure.dto

import dev.mraksimus.compat.SerialUUID
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class GameSession(
    val id: SerialUUID? = null,
    val gameId: SerialUUID,
    val wordId: SerialUUID,
    val words: List<Word>,
    val attempts: Short,
    val createdAt: LocalDateTime,
    val type: Type
) {

    @Serializable
    data class Word(
        val letters: List<Letter>,
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

    enum class Type {
        DEFAULT,
        SUPER
    }

}
