package dev.mraksimus.plugins

import dev.h4kt.ktorDocs.plugin.KtorDocs
import io.ktor.server.application.*

fun Application.configureDocs() = install(KtorDocs) {

    openApi {

        version = "3"

        info {
            version = "1"
            title = "Template project docs"
        }

        server {
            url = "http://localhost:1337"
            description = "Local development server"
        }

    }

    swagger {
        path = "/docs"
    }

}
