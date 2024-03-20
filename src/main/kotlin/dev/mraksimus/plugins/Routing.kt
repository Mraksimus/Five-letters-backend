package dev.mraksimus.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import dev.mraksimus.infrastructure.controllers.configureTestRouting
import dev.mraksimus.infrastructure.controllers.configureWordsRouting

fun Application.configureRouting() = routing {
    configureTestRouting()
    configureWordsRouting()
}
