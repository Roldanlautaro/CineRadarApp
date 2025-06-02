package com.lautarodev.cineradar.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lautarodev.cineradar.ui.screens.ShowsDetail.ShowsDetailScreen
import com.lautarodev.cineradar.ui.screens.login.LoginScreen
import com.lautarodev.cineradar.ui.screens.showslist.CineListScreen
import com.lautarodev.cineradar.ui.screens.splash.SplashScreen

@Composable
fun NavigationStack(

    onGoogleSignInClick: () -> Unit,
    navController: NavHostController
)
{
    // Las rutas de navegacion de la app

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ){

        // Pantalla Splash
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
        // Pantalla Login
        composable(route = Screens.Login.route) {
            LoginScreen(onGoogleSignInClick, navController = navController)
        }
        //Pantalla Main
        composable(route = Screens.ShowsList.route) {
            CineListScreen(navController = navController)
        }
        composable(route = Screens.ShowsDetail.route + "/{id}") { it ->
            val id = it.arguments?.getString("id") ?: ""
            ShowsDetailScreen(id = id)
        }
    }

}