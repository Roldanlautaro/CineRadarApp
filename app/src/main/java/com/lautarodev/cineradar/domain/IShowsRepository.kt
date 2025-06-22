package com.lautarodev.cineradar.domain

import com.lautarodev.cineradar.shows.shows

interface IShowsRepository {

    suspend fun fetchShows(search : String) : List<shows>
    suspend fun fetchShow(id : String) : shows

    // Pantalla main

    suspend fun getAllCienciaFiccion() : List<shows>
    suspend fun getAllMejoresPeliculasNETFLIX() : List<shows>
    suspend fun getAllMejoresPeliculasCienciaFiccionDISNEY() : List<shows>
    suspend fun getAllMejoresPeliculasTerrorHBO() : List<shows>

    // Pantalla pupular

    suspend fun getMejoresSeries() : List<shows>
    suspend fun getMejoresPeliculasDelAnio() : List<shows>
    suspend fun getMejoresSeriesDeLosUltimosAnios() : List<shows>
    suspend fun getMejoresPeliculas() : List<shows>

}