package dev.mraksimus.infrastructure.dto

import kotlinx.serialization.Serializable
import dev.mraksimus.compat.SerialUUID

@Serializable
data class Test(
    val id: SerialUUID? = null,
    val value: String
)
