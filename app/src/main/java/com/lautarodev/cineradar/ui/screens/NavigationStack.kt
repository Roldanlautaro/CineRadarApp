package com.lautarodev.cineradar.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lautarodev.cineradar.ui.screens.ShowsDetail.ShowsDetailScreen
import com.lautarodev.cineradar.ui.screens.busqueda.BusquedaScreen
import com.lautarodev.cineradar.ui.screens.lista.ListaScreen
import com.lautarodev.cineradar.ui.screens.login.LoginScreen
import com.lautarodev.cineradar.ui.screens.perfil.PerfilScreen
import com.lautarodev.cineradar.ui.screens.popular.PopularScreen
import com.lautarodev.cineradar.ui.screens.showslist.CineListScreen
import com.lautarodev.cineradar.ui.screens.splash.SplashScreen

@Composable
fun NavigationStack(

    onGoogleSignInClick: () -> Unit,
    onLogout: () -> Unit,
    navController: NavHostController,
)
{
    // Las rutas de navegacion de la app

    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {

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
        //Pantalla Detalle
        composable(route = Screens.ShowsDetail.route + "/{id}") { it ->
            val id = it.arguments?.getString("id") ?: ""
            ShowsDetailScreen(id = id, navController = navController)
        }
        //Pantalla Busqueda
        composable(route = Screens.Busqueda.route) {
            BusquedaScreen(navController = navController)
        }
        // Pantalla Popular
        composable(route = Screens.Popular.route) {
            PopularScreen(navController = navController)
        }
        // Pantalla De Perfil
        composable(route = Screens.Perfil.route) {
            PerfilScreen(
                onLogout = {
                    navController.navigate(Screens.Login.route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                },
                navController = navController
            )
        }
        // Pantalla Lista
        composable(route = Screens.Lista.route) {
            ListaScreen(navController = navController)
        }
    }
}