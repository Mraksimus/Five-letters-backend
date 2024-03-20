package dev.mraksimus.plugins.koin

import dev.mraksimus.config.database.DatabaseConfig
import dev.mraksimus.config.database.DefaultDatabaseConfig
import org.koin.dsl.module

val configModule = module(createdAtStart = true) {
    single<DatabaseConfig> { DefaultDatabaseConfig.load() }
}
