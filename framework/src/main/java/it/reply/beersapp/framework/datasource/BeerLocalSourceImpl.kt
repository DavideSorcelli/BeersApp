package it.reply.beersapp.framework.datasource

import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.data.datasource.local.BeerLocalSource


class BeerLocalSourceImpl : BeerLocalSource {

    override fun getAll(): List<Beer> {
        TODO("Not yet implemented")
    }

}