package com.lautarodev.cineradar.shows

interface ICineRadarShowsSource {

    suspend fun getShowsList(search : String): List<shows>
    suspend fun getShowById(id : String) : shows
    suspend fun getAllCienciaFiccion() : List<shows>
}