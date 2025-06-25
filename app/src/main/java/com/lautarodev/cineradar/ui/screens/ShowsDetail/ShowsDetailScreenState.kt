package com.lautarodev.cineradar.ui.screens.ShowsDetail

import com.lautarodev.cineradar.shows.emptyShows
import com.lautarodev.cineradar.shows.shows

data class ShowsDetailScreenState (
    val id: String = "",
    val ShowsDetail: shows = emptyShows(),
    val guardadosIds: List<String> = emptyList(),
    val vistosIds: List<String> = emptyList()

)

