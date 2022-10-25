package it.reply.beersapp.presentation.screens.beerlist.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import it.reply.beersapp.presentation.screens.beerlist.BeerListViewModel
import it.reply.beersapp.presentation.theme.BeersAppTheme
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BeerListScreen(
    viewModel: BeerListViewModel = hiltViewModel(),
    onBeerClick: (beerId: Long) -> Unit,
    onShowSnackBar: (message: String) -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.info.collectLatest { message ->
            onShowSnackBar(message)
        }
    }

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "IBU",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(8.dp))
            SliderFilter(
                availableRange = 0f..130f,
                onRangeSelected = { range ->
                    viewModel.onIbuRangeChanged(range = range)
                }
            )
        }

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = uiState.isLoading),
            onRefresh = { viewModel.refreshBeers() }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(
                    items = uiState.beers,
                    key = { _, beer ->
                        beer.id
                    }
                ) { _, beer ->
                    BeerListItem(
                        modifier = Modifier
                            .animateItemPlacement()
                            .clickable { onBeerClick(beer.id) },
                        beer = beer
                    )
                }
            }
        }

    }

}

@Preview
@Composable
fun BeerListScreenPreview() {
    BeersAppTheme {
        BeerListScreen(
            onBeerClick = {},
            onShowSnackBar = {}
        )
    }
}