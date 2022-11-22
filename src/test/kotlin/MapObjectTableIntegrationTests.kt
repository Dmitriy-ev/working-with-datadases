import conf.DatabaseConnect
import model.MapObjectTypeTable
import model.ShipTable
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test

class MapObjectTableIntegrationTests {

    @Test
    fun shouldFindObject(){
        init()

        transaction {
            Assert.assertEquals(1, MapObjectTypeTable.selectAll().count())
        }
        transaction {
            val foundRaw = MapObjectTypeTable.select {
                MapObjectTypeTable.type eq "new string"
            }.first()

            Assert.assertEquals("\uD83D\uDE05", foundRaw[MapObjectTypeTable.symbol])
        }
    }

    @Test
    fun shouldJoin(){
        init()
        transaction {
            Assert.assertEquals(1, ShipTable.join(MapObjectTypeTable, JoinType.LEFT).selectAll().count())
        }
    }

    companion object {
        @JvmStatic
        @BeforeClass
        fun init(){
            DatabaseConnect.connect
        }
    }
}