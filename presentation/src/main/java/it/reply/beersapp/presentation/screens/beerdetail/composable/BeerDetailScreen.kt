package it.reply.beersapp.presentation.screens.beerdetail.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import it.reply.beersapp.presentation.screens.beerdetail.BeerDetailViewModel
import it.reply.beersapp.presentation.theme.BeersAppTheme
import it.reply.beersapp.presentation.theme.Typography
import kotlinx.coroutines.flow.collectLatest

@Composable
fun BeerDetailScreen(
    viewModel: BeerDetailViewModel = hiltViewModel(),
    onShowSnackBar: (message: String) -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.info.collectLatest { message ->
            onShowSnackBar(message)
        }
    }

    val beerState = viewModel.beer.collectAsState()

    if (beerState.value != null) {

        val beer = beerState.value!!

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {

            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .align(Alignment.CenterHorizontally),
                model = beer.imageUrl,
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = beer.name,
                style = Typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = beer.description,
                style = Typography.bodyLarge
            )

        }
    }

}

@Preview
@Composable
fun BeerDetailScreenPreview() {
    BeersAppTheme {
        BeerDetailScreen(
            onShowSnackBar = {}
        )
    }
}