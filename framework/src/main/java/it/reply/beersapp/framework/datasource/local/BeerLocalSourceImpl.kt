package it.reply.beersapp.framework.datasource.local

import it.reply.beersapp.data.datasource.local.BeerLocalSource
import it.reply.beersapp.domain.model.Beer

class BeerLocalSourceImpl : BeerLocalSource {

    override fun getAll(): List<Beer> {
        TODO("Not yet implemented")
    }

}