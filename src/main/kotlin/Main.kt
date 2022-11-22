import conf.DatabaseConnect
import model.MapObjectTypeTable
import model.ShipTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {

    DatabaseConnect.connect

    transaction {
        SchemaUtils.create(MapObjectTypeTable, ShipTable)
    }

    transaction {
        val mapObjectId = MapObjectTypeTable.insert {
            it[symbol] = "\uD83D\uDE05"
            it[type] = "new string"
        }[MapObjectTypeTable.id]

        ShipTable.insert{
            it[map_object_id] = mapObjectId
            it[position] = "1,3,5"
        }
    }


    transaction {
        println(MapObjectTypeTable.selectAll().count())
    }
}