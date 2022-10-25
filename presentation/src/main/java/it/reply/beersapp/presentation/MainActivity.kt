package it.reply.beersapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import it.reply.beersapp.presentation.navigation.MainNavHost
import it.reply.beersapp.presentation.theme.BeersAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeersAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    val snackBarHostState = remember { SnackbarHostState() }

                    Scaffold(
                        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                        content = { paddingValues ->
                            MainNavHost(
                                modifier = Modifier.padding(paddingValues),
                                navController = navController,
                                snackBarHostState = snackBarHostState
                            )
                        }
                    )
                }
            }
        }
    }
}
