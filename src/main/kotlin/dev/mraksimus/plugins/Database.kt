package dev.mraksimus.plugins

import io.ktor.server.application.*
import kotlinx.coroutines.Dispatchers
import dev.mraksimus.config.database.DatabaseConfig
import dev.mraksimus.infrastructure.models.GameModel
import dev.mraksimus.infrastructure.models.GameSessionModel
import dev.mraksimus.infrastructure.models.UserModel
import dev.mraksimus.infrastructure.models.WordModel
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject

fun Application.configureDatabase() {

    val config by inject<DatabaseConfig>()

    Database.connect(
        url = config.jdbcConnectionUrl,
        user = config.username,
        password = config.password
    )

    transaction {
        SchemaUtils.createMissingTablesAndColumns(
            WordModel,
            UserModel,
            GameModel,
            GameSessionModel
        )
    }

}

suspend fun <R> suspendedTransaction(statement: Transaction.() -> R) = newSuspendedTransaction(
    context = Dispatchers.IO,
    statement = statement
)
