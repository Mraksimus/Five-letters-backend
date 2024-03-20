package dev.mraksimus.infrastructure.dto

import dev.mraksimus.compat.SerialUUID
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
data class User(
    val id: SerialUUID? = null,
    val index: String,
    val profile: Profile,
    val createdAt: LocalDateTime
) {
    @OptIn(ExperimentalSerializationApi::class)
    @Serializable
    @JsonClassDiscriminator("platform")
    sealed interface Profile {

        val id: String

        @Serializable
        @SerialName("VK")
        data class VK(
            override val id: String,
            val firstName: String,
            val lastName: String,
            val photoUrl: String
        ) : Profile

        @Serializable
        @SerialName("Telegram")
        data class Telegram(
            override val id: String,
            val nickname: String,
            val photoUrl: String
        ) : Profile

    }
}