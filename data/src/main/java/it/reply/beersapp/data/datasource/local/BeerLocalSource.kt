package it.reply.beersapp.data.datasource.local

import it.reply.beersapp.domain.model.Beer

interface BeerLocalSource {
    fun getAll(): List<Beer>
}