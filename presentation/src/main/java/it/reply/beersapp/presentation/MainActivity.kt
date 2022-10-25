package it.reply.beersapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import it.reply.beersapp.presentation.screens.beerdetail.composable.BeerDetailScreen
import it.reply.beersapp.presentation.screens.beerlist.composable.BeerListScreen
import it.reply.beersapp.presentation.theme.BeersAppTheme
import it.reply.beersapp.presentation.utils.navigateSingleTop

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeersAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "beers_list"
                    ) {
                        composable(route = "beers_list") {
                            BeerListScreen(
                                onBeerClick = { beerId ->
                                    navController.navigateSingleTop(route = "beer_detail/$beerId")
                                }
                            )
                        }
                        composable(
                            route = "beer_detail/{beerId}",
                            arguments = listOf(navArgument("beerId") { type = NavType.LongType })
                        ) { backStackEntry ->
                            BeerDetailScreen(
                                beerId = backStackEntry.arguments?.getLong("beerId")
                                    ?: throw RuntimeException("Argument beerId required for destination beer_detail")
                            )
                        }
                    }
                }
            }
        }
    }
}
