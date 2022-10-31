package it.reply.beersapp.presentation.screens.beerdetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import it.reply.beersapp.domain.model.Beer
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel @Inject constructor(

) : ViewModel() {

    private val _beer: MutableStateFlow<Beer?> = MutableStateFlow(null)
    val beer = _beer.asStateFlow()

    private val _info: MutableSharedFlow<String> = MutableSharedFlow()
    val info = _info.asSharedFlow()

    fun getBeerById(beerId: Long) {
        _beer.update {
            Beer.mock()
        }
    }

}