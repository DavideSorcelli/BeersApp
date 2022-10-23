package it.reply.beersapp.data.repository

import it.reply.beersapp.data.datasource.local.BeerLocalSource
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.domain.repository.BeerRepository

class BeerRepositoryImpl constructor(
    private val beerLocalSource: BeerLocalSource
): BeerRepository {

    override suspend fun fetchBeers(): List<Beer> {
        TODO("Not yet implemented")
    }

}