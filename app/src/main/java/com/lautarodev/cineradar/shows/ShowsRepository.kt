package com.lautarodev.cineradar.shows

import com.lautarodev.cineradar.domain.IShowsRepository

class ShowsRepository(
        var CineRadarShowsSource : ICineRadarShowsSource = ShowsApiDataSource()
) : IShowsRepository

{


    override suspend fun fetchShows(search : String) : List<shows>{
        return CineRadarShowsSource.getShowsList(search)
    }

    override suspend fun fetchShow(id: String): shows {
        return CineRadarShowsSource.getShowById(id)
    }

    // Pantalla main

    override suspend fun getAllCienciaFiccion(): List<shows> {
        return CineRadarShowsSource.getAllCienciaFiccion()
    }

    override suspend fun getAllMejoresPeliculasNETFLIX(): List<shows> {
        return CineRadarShowsSource.getAllMejoresPeliculasNETFLIX()
    }

    override suspend fun getAllMejoresPeliculasCienciaFiccionDISNEY(): List<shows> {
        return CineRadarShowsSource.getAllMejoresPeliculasCienciaFiccionDISNEY()
    }

    override suspend fun getAllMejoresPeliculasTerrorHBO(): List<shows> {
        return CineRadarShowsSource.getAllMejoresPeliculasTerrorHBO()
    }

    // Pantalla Popular

    override suspend fun getMejoresSeries(): List<shows> {
        return CineRadarShowsSource.getMejoresSeries()
    }

    override suspend fun getMejoresPeliculasDelAnio(): List<shows> {
        return CineRadarShowsSource.getMejoresPeliculasDelAnio()
    }

    override suspend fun getMejoresSeriesDeLosUltimosAnios(): List<shows> {
        return CineRadarShowsSource.getMejoresSeriesDeLosUltimosAnios()
    }

    override suspend fun getMejoresPeliculas(): List<shows> {
        return CineRadarShowsSource.getMejoresPeliculas()
    }


}
