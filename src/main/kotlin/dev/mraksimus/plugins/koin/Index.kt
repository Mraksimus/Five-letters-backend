package dev.mraksimus.plugins.koin

import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureKoin() = install(Koin) {

}
