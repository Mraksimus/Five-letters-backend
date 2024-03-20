package dev.mraksimus.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

val json = Json {
    ignoreUnknownKeys = true
    prettyPrint = true
}

fun Application.configureContentNegotiation() = install(ContentNegotiation) {
    json(json)
}
