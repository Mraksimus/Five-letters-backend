package dev.mraksimus

import io.ktor.server.application.*
import io.ktor.server.netty.*
import dev.mraksimus.plugins.*
import dev.mraksimus.plugins.koin.configureKoin

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {

    configureKoin()

    configureDatabase()

    configureContentNegotiation()

    configureAuthentication()
    configureRouting()
    configureDocs()

}

