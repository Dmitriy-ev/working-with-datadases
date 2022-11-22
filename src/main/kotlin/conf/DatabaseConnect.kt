package conf

import org.jetbrains.exposed.sql.Database

object DatabaseConnect {

    val connect = Database.connect("jdbc:sqlite:./sea-battle.db", "org.sqlite.JDBC")

}