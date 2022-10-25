package it.reply.beersapp.presentation.screens.beerlist.composable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
        modifier = modifier
            .height(72.dp),
        leadingContent = {
            AsyncImage(
                modifier = Modifier.width(36.dp),
                model = beer.imageUrl,
                contentDescription = null
            )
        },
        headlineText = {
            Text(
                text = beer.name,
                fontWeight = FontWeight.SemiBold
            )
        },
        supportingText = {
            Text(
                text = beer.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        },
        shadowElevation = 4.dp
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