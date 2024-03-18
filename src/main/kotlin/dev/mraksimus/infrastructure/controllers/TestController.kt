package dev.mraksimus.infrastructure.controllers

import dev.h4kt.ktorDocs.dsl.get
import dev.h4kt.ktorDocs.dsl.post
import dev.h4kt.ktorDocs.types.parameters.RouteParameters
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
import org.koin.ktor.ext.inject

fun Routing.configureTestRouting() = route("/test") {

    configurePublicRoutes()

    authenticate("template") {
        configureAuthenticatedRoutes()
    }

}

private fun Route.configurePublicRoutes() {

    val testRepository by inject<ITestRepository>()

    class GetParams : RouteParameters() {

        val offset by query.long {
            name = "offset"
        }

        val limit by query.int {
            name = "limit"
        }

    }

    get(::GetParams) {

        description = "Get list of all test objects"

        responses {
            HttpStatusCode.OK returns typeInfo<PageResponse<Test>>()
        }

        handle {

            val result = suspendedTransaction {
                testRepository.findAll(
                    offset = parameters.offset,
                    limit = parameters.limit
                )
            }

            call.respond(result)
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
