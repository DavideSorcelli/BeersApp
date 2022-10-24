package it.reply.beersapp.domain.repository

import it.reply.beersapp.domain.model.Beer
import kotlinx.coroutines.flow.Flow

interface BeerRepository {

    /**
     * Fetch beers from service and save a copy in database
     */
    suspend fun fetchBeers(): List<Beer>

    /**
     * Suspend version
     */
    suspend fun getBeers(): List<Beer>

    /**
     * Reactive version
     */
    fun observeBeers(): Flow<List<Beer>>

}