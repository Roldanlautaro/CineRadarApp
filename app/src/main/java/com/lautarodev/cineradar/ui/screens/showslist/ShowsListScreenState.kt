package com.lautarodev.cineradar.ui.screens.showslist

import com.lautarodev.cineradar.shows.shows


data class ShowsListScreenState(
    val cienciaFiccion: List<shows> = emptyList(),
    val netflixTop: List<shows> = emptyList(),
    val disneyScifi: List<shows> = emptyList(),
    val hboHorror: List<shows> = emptyList()
)
