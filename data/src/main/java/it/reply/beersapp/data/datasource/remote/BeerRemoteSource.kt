package it.reply.beersapp.data.datasource.remote

import it.reply.beersapp.domain.model.Beer

interface BeerRemoteSource {
    suspend fun getAll(): List<Beer>
}