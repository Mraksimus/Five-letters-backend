package dev.mraksimus.config

import io.ktor.server.config.*
import io.ktor.server.config.ConfigLoader.Companion.load

object WordsConfig {

    private val handle = ConfigLoader.load("words.conf")

    val word = handle.property("five_letters").getList()

}