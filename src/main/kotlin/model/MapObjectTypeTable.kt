package model

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object MapObjectTypeTable: IntIdTable("map_object_type", "id") {

    //val id = integer("id").uniqueIndex().autoIncrement()
    val type = varchar("type", 10)
    val symbol = varchar("symbol", 10)

    //override val primaryKey: PrimaryKey = PrimaryKey(id)
}