package it.reply.beersapp.framework.datasource.local

import it.reply.beersapp.data.datasource.local.BeerLocalSource
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.framework.database.dao.BeerDao
import it.reply.beersapp.framework.database.mapper.toDomain
import it.reply.beersapp.framework.database.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BeerLocalSourceImpl @Inject constructor(
    private val beerDao: BeerDao
) : BeerLocalSource {

    override suspend fun save(beers: List<Beer>) {
        beerDao.insert(*beers.map {
            it.toEntity()
        }.toTypedArray())
    }

    override suspend fun getAll(): List<Beer> {
        return beerDao.getAll().map { it.toDomain() }
    }

    override fun getAllAsFlow(): Flow<List<Beer>> {
        return beerDao.getAllAsFlow().map { beersEntities ->
            beersEntities.map { it.toDomain() }
        }
    }

}