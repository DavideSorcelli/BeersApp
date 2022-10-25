package it.reply.beersapp.presentation.screens.beerlist.composable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import it.reply.beersapp.presentation.theme.BeersAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderFilter(
    availableRange: ClosedFloatingPointRange<Float>,
    onRangeSelected: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier
) {

    var sliderPosition by remember {
        mutableStateOf(availableRange)
    }

    RangeSlider(
        modifier = modifier,
        valueRange = availableRange,
        value = sliderPosition,
        onValueChange = {
            sliderPosition = it
        },
        onValueChangeFinished = {
            onRangeSelected(sliderPosition)
        }
    )

}

@Preview
@Composable
fun SliderFilterPreview() {
    BeersAppTheme {
        SliderFilter(
            availableRange = 0f..100f,
            onRangeSelected = {},
        )
    }
}