package dev.mraksimus.infrastructure.controllers

import dev.h4kt.ktorDocs.dsl.get
import dev.h4kt.ktorDocs.dsl.post
import dev.h4kt.ktorDocs.types.parameters.RouteParameters
import dev.mraksimus.config.WordsConfig
import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.reflect.*
import dev.mraksimus.infrastructure.dto.PageResponse
import dev.mraksimus.infrastructure.dto.Test
import dev.mraksimus.infrastructure.repositories.ITestRepository
import dev.mraksimus.plugins.suspendedTransaction
import io.ktor.server.config.*
import io.ktor.server.config.ConfigLoader.Companion.load
import org.koin.ktor.ext.inject
import kotlin.random.Random

fun Routing.configureWordsRouting() = route("/word") {

    configurePublicRoutes()

}

private fun Route.configurePublicRoutes() {

    get("/random") {

        handle {

            val wordList = WordsConfig.word

            val randomNumber = Random.nextInt(wordList.size)

            call.respond(wordList[randomNumber])
        }

    }

}

private fun Route.configureAuthenticatedRoutes() {

    val testRepository by inject<ITestRepository>()

    post("new") {

        description = "Create new test object"
        requestBody = typeInfo<Test>()

        handle {

            val body = call.receive<Test>()

            val result = suspendedTransaction {
                testRepository.create(body)
            }

            call.respond(result)
        }

    }

}
