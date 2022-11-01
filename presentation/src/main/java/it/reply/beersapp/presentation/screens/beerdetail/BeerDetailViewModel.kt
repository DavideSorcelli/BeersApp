package it.reply.beersapp.presentation.screens.beerdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import it.reply.beersapp.domain.model.Beer
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _beer: MutableStateFlow<Beer?> = MutableStateFlow(null)
    val beer = _beer.asStateFlow()

    private val _info: MutableSharedFlow<String> = MutableSharedFlow()
    val info = _info.asSharedFlow()

    init {
        val beerId = savedStateHandle.get<Long>("beerId")
        beerId?.let {
            Timber.d("BeerDetailViewModel initialized for beerId: $beerId")
            getBeerById(beerId = beerId)
        } ?: run {
            Timber.d("BeerDetailViewModel failed to initialize, beerId param was null")
        }
    }

    private fun getBeerById(beerId: Long) {
        _beer.update {
            Beer.mock()
        }
    }

}