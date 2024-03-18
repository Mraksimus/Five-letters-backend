package dev.mraksimus.config.database

import dev.mraksimus.config.ConfigFactory
import kotlinx.serialization.Serializable

@Serializable
class DefaultDatabaseConfig(
    override val driver: String,
    override val host: String,
    override val port: UShort,
    override val username: String,
    override val database: String,
    override val password: String
) : DatabaseConfig {
    
    companion object : ConfigFactory<DatabaseConfig>("database.conf") {

        override fun load(path: String): DatabaseConfig {
            return deserialize<DefaultDatabaseConfig>(path)
        }
        
    }
    
}
