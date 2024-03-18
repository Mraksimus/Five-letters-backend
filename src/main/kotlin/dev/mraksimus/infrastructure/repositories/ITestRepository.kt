package dev.mraksimus.infrastructure.repositories

import dev.mraksimus.infrastructure.dto.PageResponse
import dev.mraksimus.infrastructure.dto.Test
import java.util.*

interface ITestRepository {

    fun create(dto: Test): Test

    fun findAll(
        offset: Long,
        limit: Int
    ): PageResponse<Test>

    fun update(
        id: UUID,
        dto: Test
    )

    fun delete(id: UUID)

}
