package dev.mraksimus.infrastructure.repositories

import dev.mraksimus.extensions.deleteById
import dev.mraksimus.extensions.updateById
import dev.mraksimus.infrastructure.dto.PageResponse
import dev.mraksimus.infrastructure.dto.Test
import dev.mraksimus.infrastructure.models.TestModel
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import java.util.*

class TestRepository : ITestRepository {

    override fun create(dto: Test): Test {

        val insertedRow = TestModel.insert {
            it[this.value]
        }

        return dto.copy(id = insertedRow[TestModel.id].value)
    }

    override fun findAll(
        offset: Long,
        limit: Int
    ): PageResponse<Test> {

        val total = TestModel.selectAll().count()
        val items = TestModel.selectAll()
            .limit(limit, offset)
            .map {
                Test(
                    id = it[TestModel.id].value,
                    value = it[TestModel.value]
                )
            }

        return PageResponse(
            total = total,
            offset = offset,
            limit = limit,
            items = items
        )
    }

    override fun update(
        id: UUID,
        dto: Test
    ) {

        TestModel.updateById(id) {
            it[this.value] = dto.value
        }

    }

    override fun delete(id: UUID) {
        TestModel.deleteById(id)
    }

}
