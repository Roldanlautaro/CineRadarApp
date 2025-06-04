package com.lautarodev.cineradar.ui.screens.busqueda

import com.lautarodev.cineradar.shows.shows

data class BusquedaScreenState(

    val showsList : List<shows> = emptyList(),
    val searchQuery: String = ""

)