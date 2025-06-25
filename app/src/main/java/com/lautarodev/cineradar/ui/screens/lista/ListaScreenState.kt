package com.lautarodev.cineradar.ui.screens.lista

import com.lautarodev.cineradar.shows.shows

data class ListaScreenState(

    val listaShows: List<shows> = emptyList(),
    val guardadosIds: List<String> = emptyList()

)