package it.reply.beersapp.presentation.screens.beerlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.domain.usecase.FetchAndObserveBeersUC
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BeerListViewModel @Inject constructor(
    private val fetchAndObserveBeersUC: FetchAndObserveBeersUC
) : ViewModel() {

    private val _uiState = MutableStateFlow(BeerListUiState())
    val uiState = _uiState.asStateFlow()

    private val _info: MutableSharedFlow<String> = MutableSharedFlow()
    val info = _info.asSharedFlow()

    init {
        fetchAndObserveBeersUC.invoke()
            .onStart {
                _uiState.update { BeerListUiState(isLoading = true) }
            }.onEach { beers ->
                _uiState.update { BeerListUiState(beers = beers) }
            }.catch { e ->
                _uiState.update { BeerListUiState(isError = true) }
                Timber.e("fetchAndObserveBeersUC error: $e")
            }.launchIn(viewModelScope)
    }

    fun refreshBeers() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true, isError = false)
            }
            fetchAndObserveBeersUC.refreshBeers()
        }
    }

    fun onIbuRangeChanged(range: ClosedFloatingPointRange<Float>) {
        viewModelScope.launch {
            _info.emit("Range selected: $range")
        }
    }

    data class BeerListUiState(
        val isLoading: Boolean = false,
        val beers: List<Beer> = emptyList(),
        val isError: Boolean = false
    )

}