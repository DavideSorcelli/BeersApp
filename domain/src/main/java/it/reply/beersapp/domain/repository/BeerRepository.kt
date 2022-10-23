package it.reply.beersapp.domain.repository

import it.reply.beersapp.domain.model.Beer

interface BeerRepository {
    suspend fun fetchBeers(): List<Beer>
}