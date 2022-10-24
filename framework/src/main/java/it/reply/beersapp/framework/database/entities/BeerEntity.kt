package it.reply.beersapp.framework.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import it.reply.beersapp.framework.database.entities.BeerEntity.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class BeerEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String
) {
    internal companion object {
        const val TABLE_NAME = "beer"
    }
}
