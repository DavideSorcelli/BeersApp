package it.reply.beersapp.framework.datasource.remote

import it.reply.beersapp.data.datasource.remote.BeerRemoteSource
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.framework.service.api.BeerApi
import it.reply.beersapp.framework.service.mapper.toDomain
import javax.inject.Inject

class BeerRemoteSourceImpl @Inject constructor(
    private val beerApi: BeerApi
): BeerRemoteSource {

    override suspend fun getAll(): List<Beer> {
        return beerApi.getBeers().map { it.toDomain() }
    }

}