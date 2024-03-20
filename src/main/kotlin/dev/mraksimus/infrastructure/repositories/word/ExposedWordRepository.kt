package dev.mraksimus.infrastructure.repositories.word

import dev.mraksimus.compat.SerialUUID
import dev.mraksimus.infrastructure.dto.Word

class ExposedWordRepository : WordRepository {

    override fun create(dto: Word) {
        TODO("Not yet implemented")
    }

    override fun delete(id: SerialUUID) {
        TODO("Not yet implemented")
    }

    override fun update(id: SerialUUID, value: String) {
        TODO("Not yet implemented")
    }

}