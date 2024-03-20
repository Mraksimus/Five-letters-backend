package dev.mraksimus.infrastructure.repositories.word

import dev.mraksimus.compat.SerialUUID
import dev.mraksimus.extensions.deleteById
import dev.mraksimus.extensions.updateById
import dev.mraksimus.infrastructure.dto.Word
import dev.mraksimus.infrastructure.models.WordModel
import org.jetbrains.exposed.sql.insert

class ExposedWordRepository : WordRepository {

    override fun create(dto: Word): Word {

        val insertedRow = WordModel.insert {
            it[id] = SerialUUID.randomUUID()
            it[value] = dto.value
        }

        return dto.copy(id = insertedRow[WordModel.id].value)
    }

    override fun delete(id: SerialUUID): Int {
        return WordModel.deleteById(id)
    }

    override fun update(
        id: SerialUUID,
        value: String
    ): Int {
        return WordModel.updateById(id) {
            it[this.value] = value
        }
    }

}