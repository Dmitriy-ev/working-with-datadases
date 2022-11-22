package model

import org.jetbrains.exposed.dao.id.IntIdTable

object ShipTable: IntIdTable("ship", "id") {
    val position = varchar("position", 10)
    val map_object_id = reference("map_object_id", MapObjectTypeTable)
}