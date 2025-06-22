package com.lautarodev.cineradar.ui.screens

sealed class Screens(val route: String) {

    object Splash: Screens("Splash")
    object ShowsList: Screens("Shows_List_Screen")
    object ShowsDetail : Screens("Shows_Detail_Screen")
    object Login: Screens("login_screen")
    object Busqueda: Screens("Busqueda_Screen")
    object Loader : Screens ("Loader_Screen")
    object Popular : Screens ("Popular_Screen")
}