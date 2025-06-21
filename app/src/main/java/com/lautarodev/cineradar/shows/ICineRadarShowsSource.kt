package com.lautarodev.cineradar.shows

interface ICineRadarShowsSource {

    suspend fun getShowsList(search : String): List<shows>
    suspend fun getShowById(id : String) : shows

    // Pantalla main

    suspend fun getAllCienciaFiccion() : List<shows>
    suspend fun getAllMejoresPeliculasNETFLIX() : List<shows>
    suspend fun getAllMejoresPeliculasCienciaFiccionDISNEY() : List<shows>
    suspend fun getAllMejoresPeliculasTerrorHBO() : List<shows>
}