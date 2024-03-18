package dev.mraksimus

import io.ktor.server.application.*
import io.ktor.server.netty.*
import dev.mraksimus.plugins.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {

    configureDatabase()

    configureContentNegotiation()

    configureAuthentication()
    configureRouting()
    configureDocs()

}

