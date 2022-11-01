package it.reply.beersapp.presentation.screens.beerdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.domain.repository.BeerRepository
import kotlinx.coroutines.flow.*
import timber.log.Timber

class BeerDetailViewModel @AssistedInject constructor(
    @Assisted private val beerId: Long,
    private val beerRepo: BeerRepository
) : ViewModel() {

    private val _beer: MutableStateFlow<Beer?> = MutableStateFlow(null)
    val beer = _beer.asStateFlow()

    private val _info: MutableSharedFlow<String> = MutableSharedFlow()
    val info = _info.asSharedFlow()

    init {
        Timber.tag("DAVE").d("Beer id: $beerId")
    }

    fun getBeerById(beerId: Long) {
        _beer.update {
            Beer.mock()
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(noteId: Long): BeerDetailViewModel
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provideFactory(
            assistedFactory: Factory,
            beerId: Long
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(beerId) as T
            }
        }
    }

}