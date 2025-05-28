package com.lautarodev.cineradar.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lautarodev.cineradar.ui.screens.ShowsDetail.ShowsDetailScreen
import com.lautarodev.cineradar.ui.screens.showslist.CineListScreen
import com.lautarodev.cineradar.ui.screens.splash.SplashScreen

@Composable
fun NavigationStack(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ){

        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.ShowsList.route) {
            CineListScreen(navController = navController)
        }
        composable(route = Screens.ShowsDetail.route + "/{id}") { it ->
            val id = it.arguments?.getString("id") ?: ""
            ShowsDetailScreen(id = id)
        }
    }

}