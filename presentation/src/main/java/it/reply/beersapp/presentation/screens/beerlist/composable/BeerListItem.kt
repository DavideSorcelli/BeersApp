package it.reply.beersapp.presentation.screens.beerlist.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.presentation.theme.BeersAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeerListItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {
    ListItem(
        leadingContent = {
            AsyncImage(
                model = beer.imageUrl,
                modifier = Modifier.height(60.dp),
                contentDescription = ""
            )
        },
        headlineText = {
            Text(text = beer.name)
        },
        supportingText = {
            Text(text = beer.description, maxLines = 1, overflow = TextOverflow.Ellipsis)
        },
        modifier = modifier,
        shadowElevation = 16.dp
    )
}

@Preview
@Composable
fun BeerListItemPreview() {
    BeersAppTheme {
        BeerListItem(
            beer = Beer.mock()
        )
    }
}