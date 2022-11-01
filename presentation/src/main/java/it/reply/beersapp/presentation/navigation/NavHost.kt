package it.reply.beersapp.presentation.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import it.reply.beersapp.presentation.screens.beerdetail.composable.BeerDetailScreen
import it.reply.beersapp.presentation.screens.beerlist.composable.BeerListScreen
import it.reply.beersapp.presentation.utils.navigateSingleTop
import kotlinx.coroutines.launch

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    snackBarHostState: SnackbarHostState
) {

    val coroutineScope = rememberCoroutineScope()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "beers_list"
    ) {
        composable(route = "beers_list") {
            BeerListScreen(
                onBeerClick = { beerId ->
                    navController.navigateSingleTop(route = "beer_detail/$beerId")
                },
                onShowSnackBar = { message ->
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(message)
                    }
                }
            )
        }
        composable(
            route = "beer_detail/{beerId}",
            arguments = listOf(navArgument("beerId") { type = NavType.LongType })
        ) {
            BeerDetailScreen(
                onShowSnackBar = { message ->
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(message)
                    }
                }
            )
        }
    }

}