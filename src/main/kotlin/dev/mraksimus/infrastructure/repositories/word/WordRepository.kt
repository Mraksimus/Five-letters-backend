package dev.mraksimus.infrastructure.repositories.word

import dev.mraksimus.compat.SerialUUID
import dev.mraksimus.infrastructure.dto.Word
import dev.mraksimus.infrastructure.models.WordModel

interface WordRepository {

    fun create(dto: Word): Word

    fun delete(id: SerialUUID): Int

    fun update(
        id: SerialUUID,
        value: String
    ): Int

}