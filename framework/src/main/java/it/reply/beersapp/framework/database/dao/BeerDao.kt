package it.reply.beersapp.framework.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import it.reply.beersapp.framework.database.entities.BeerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg posts: BeerEntity)

    @Query("SELECT * FROM ${BeerEntity.TABLE_NAME}")
    suspend fun getAll(): List<BeerEntity>

    @Query("SELECT * FROM ${BeerEntity.TABLE_NAME}")
    fun getAllAsFlow(): Flow<List<BeerEntity>>

}