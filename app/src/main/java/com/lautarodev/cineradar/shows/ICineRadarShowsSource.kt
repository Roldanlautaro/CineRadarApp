package com.lautarodev.cineradar.shows

interface ICineRadarShowsSource {

    suspend fun getShowsList(search : String): List<shows>
    suspend fun getShowById(id : String) : shows

    // Pantalla main

    suspend fun getAllCienciaFiccion() : List<shows>
    suspend fun getAllMejoresPeliculasNETFLIX() : List<shows>
    suspend fun getAllMejoresPeliculasCienciaFiccionDISNEY() : List<shows>
    suspend fun getAllMejoresPeliculasTerrorHBO() : List<shows>

    // Pantalla popular

    suspend fun getMejoresSeries() : List<shows>
    suspend fun getMejoresPeliculasDelAnio() : List<shows>
    suspend fun getMejoresSeriesDeLosUltimosAnios() : List<shows>
    suspend fun getMejoresPeliculas() : List<shows>
}