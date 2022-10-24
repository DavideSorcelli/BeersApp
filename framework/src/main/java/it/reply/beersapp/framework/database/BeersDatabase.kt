package it.reply.beersapp.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import it.reply.beersapp.framework.database.dao.BeerDao
import it.reply.beersapp.framework.database.entities.BeerEntity

@Database(
    entities = [
        BeerEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class BeersDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDao
}