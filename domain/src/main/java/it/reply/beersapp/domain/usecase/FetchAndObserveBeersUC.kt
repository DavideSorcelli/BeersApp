package it.reply.beersapp.domain.usecase

import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.domain.repository.BeerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface FetchAndObserveBeersUC {
    operator fun invoke(): Flow<List<Beer>>
    suspend fun refreshBeers()
}

class FetchAndObserveBeersUCImpl @Inject constructor(
    private val beerRepository: BeerRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): FetchAndObserveBeersUC {

    override fun invoke(): Flow<List<Beer>> = flow {
        beerRepository.fetchBeers()
        emitAll(beerRepository.observeBeers())
    }.flowOn(ioDispatcher)

    override suspend fun refreshBeers() {
        withContext(ioDispatcher) {
            beerRepository.fetchBeers()
        }
    }

}