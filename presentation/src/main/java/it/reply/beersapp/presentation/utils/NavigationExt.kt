package it.reply.beersapp.presentation.utils

import androidx.navigation.NavHostController

fun NavHostController.navigateSingleTop(route: String) {
    navigate(route = route) {
        launchSingleTop = true
    }
}