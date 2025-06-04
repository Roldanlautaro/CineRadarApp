package com.lautarodev.cineradar.ui.screens.showslist

import com.lautarodev.cineradar.shows.shows


data class ShowsListScreenState(
    val showsList: List<shows> = emptyList(),
    val searchQuery: String = "",
)