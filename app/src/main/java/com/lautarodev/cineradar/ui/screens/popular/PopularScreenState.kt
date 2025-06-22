package com.lautarodev.cineradar.ui.screens.popular

import com.lautarodev.cineradar.shows.shows

data class PopularScreenState (
    val mejoresSeries: List<shows> = emptyList(),
    val mejoresPeliculasDelAnio: List<shows> = emptyList(),
    val mejoresSeriesDeLosUltimosAnios : List<shows> = emptyList(),
    val mejoresPeliculas: List<shows> = emptyList()
)