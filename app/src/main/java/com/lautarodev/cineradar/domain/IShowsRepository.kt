package com.lautarodev.cineradar.domain

import com.lautarodev.cineradar.shows.shows

interface IShowsRepository {

    suspend fun fetchShows(search : String) : List<shows>
    suspend fun fetchShow(id : String) : shows
    suspend fun getAllCienciaFiccion() : List<shows>
}