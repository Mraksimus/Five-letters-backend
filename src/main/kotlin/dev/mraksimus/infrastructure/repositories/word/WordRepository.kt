package dev.mraksimus.infrastructure.repositories.word

import dev.mraksimus.compat.SerialUUID
import dev.mraksimus.infrastructure.dto.Word

interface WordRepository {

    fun create(dto: Word)

    fun delete(id: SerialUUID)

    fun update(
        id: SerialUUID,
        value: String
    )

}