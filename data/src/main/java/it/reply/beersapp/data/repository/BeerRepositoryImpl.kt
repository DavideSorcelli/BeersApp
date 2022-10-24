package it.reply.beersapp.data.repository

import it.reply.beersapp.data.datasource.local.BeerLocalSource
import it.reply.beersapp.data.datasource.remote.BeerRemoteSource
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BeerRepositoryImpl @Inject constructor(
    private val beerLocalSource: BeerLocalSource,
    private val beerRemoteSource: BeerRemoteSource
): BeerRepository {

    override suspend fun fetchBeers(): List<Beer> {
        val beers = beerRemoteSource.getAll()
        beerLocalSource.save(beers = beers)
        return beers
    }

    override suspend fun getBeers(): List<Beer> =
        beerLocalSource.getAll()

    override fun observeBeers(): Flow<List<Beer>> =
        beerLocalSource.getAllAsFlow()

}