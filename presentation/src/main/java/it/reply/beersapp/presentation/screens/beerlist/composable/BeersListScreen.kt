package it.reply.beersapp.presentation.screens.beerlist.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import it.reply.beersapp.presentation.screens.beerlist.BeerListViewModel
import it.reply.beersapp.presentation.theme.BeersAppTheme

@Composable
fun BeerListScreen(
    viewModel: BeerListViewModel = hiltViewModel(),
    onBeerClick: (beerId: Long) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = uiState.isLoading),
        onRefresh = { viewModel.refreshBeers() }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(
                items = uiState.beers,
                key = { _, beer ->
                    beer.id
                }
            ) { _, beer ->
                BeerListItem(
                    modifier = Modifier.clickable {
                        onBeerClick(beer.id)
                    },
                    beer = beer
                )
            }
        }
    }

}

@Preview
@Composable
fun BeerListScreenPreview() {
    BeersAppTheme {
        BeerListScreen(
            onBeerClick = {}
        )
    }
}