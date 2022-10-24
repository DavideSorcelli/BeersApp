package it.reply.beersapp.data.datasource.local

import it.reply.beersapp.domain.model.Beer
import kotlinx.coroutines.flow.Flow

interface BeerLocalSource {
    suspend fun save(beers: List<Beer>)
    suspend fun getAll(): List<Beer>
    fun getAllAsFlow(): Flow<List<Beer>>
}