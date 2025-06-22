package com.lautarodev.cineradar.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star

// Elementos del navbar

val navigationItems = listOf(
    NavigationItem(
        title = "Inicio",
        icon = Icons.Default.Home,
        route = Screens.ShowsList.route
    ),
    NavigationItem(
        title = "Busqueda",
        icon = Icons.Default.Search,
        route = Screens.Busqueda.route
    ),
    NavigationItem(
        title = "Popular",
        icon = Icons.Default.Star,
        route = Screens.Popular.route
    ),
    NavigationItem(
        title = "Listas",
        icon = Icons.AutoMirrored.Filled.List,
        route = ""
    ),
    NavigationItem(
        title = "Perfil",
        icon = Icons.Default.Person,
        route = Screens.Perfil.route
    )

)