package dev.mraksimus.config

import kotlinx.serialization.*
import com.typesafe.config.ConfigFactory as HoconConfigFactory
import kotlinx.serialization.hocon.Hocon
import kotlinx.serialization.hocon.decodeFromConfig
import java.io.File

abstract class ConfigFactory<T : Any>(
    protected val defaultPath: String,
    protected val format: SerialFormat = Hocon {}
) {

    abstract fun load(
        path: String = defaultPath
    ): T
    
    @OptIn(ExperimentalSerializationApi::class)
    protected inline fun <reified T : Any> deserialize(
        path: String
    ): T {
        val file = File(path)
        return when (format) {
            is Hocon -> {
                val config = HoconConfigFactory.parseFile(file)
                format.decodeFromConfig(config)
            }
            is StringFormat ->
                format.decodeFromString(file.readText())
            is BinaryFormat ->
                format.decodeFromByteArray(file.readBytes())
            else ->
                throw UnsupportedOperationException("Unsupported serial format: ${format::class.simpleName}")
        }
    }
    
}
