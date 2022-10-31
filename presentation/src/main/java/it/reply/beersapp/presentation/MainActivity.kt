package it.reply.beersapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import it.reply.beersapp.R
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
                    val currentBackStackEntry by navController.currentBackStackEntryAsState()
                    val snackBarHostState = remember { SnackbarHostState() }

                    Scaffold(
                        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                        topBar = {
                            TopAppBar(
                                title = { Text(text = stringResource(id = R.string.app_name)) },
                                navigationIcon = {
                                    if (currentBackStackEntry != null &&
                                        navController.previousBackStackEntry != null
                                    ) {
                                        IconButton(onClick = { navController.popBackStack() }) {
                                            Icon(
                                                imageVector = Icons.Filled.ArrowBack,
                                                contentDescription = ""
                                            )
                                        }
                                    }
                                }
                            )
                        },
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
