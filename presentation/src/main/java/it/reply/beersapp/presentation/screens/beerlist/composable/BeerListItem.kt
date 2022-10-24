package it.reply.beersapp.presentation.screens.beerlist.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import it.reply.beersapp.domain.model.Beer
import it.reply.beersapp.presentation.theme.BeersAppTheme
import it.reply.beersapp.presentation.theme.Typography

@Composable
fun BeerListItem(
    beer: Beer,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.padding(8.dp)) {
        Text(text = beer.name, style = Typography.titleLarge)
        Spacer(modifier = modifier.height(8.dp))
        Text(text = beer.description)
    }

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