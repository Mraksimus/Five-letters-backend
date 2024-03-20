package dev.mraksimus.infrastructure.models

import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.ReferenceOption
import java.util.*

object GameModel : IdTable<UUID>("games") {

    val userId = reference("user_id", UserModel, onDelete = ReferenceOption.CASCADE)
    val lives = integer("lives")
    val score = integer("score")

    override val id = userId

}