package dev.mraksimus.infrastructure.dto

import dev.mraksimus.compat.SerialUUID
import kotlinx.serialization.Serializable

@Serializable
data class Word(
    val id: SerialUUID,
    val value: String,
    val caption: String
)
