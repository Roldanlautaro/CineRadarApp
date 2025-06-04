package com.lautarodev.cineradar.shows

import com.lautarodev.cineradar.domain.IShowsRepository

class ShowsRepository(
        var CineRadarShowsSource : ICineRadarShowsSource = ShowsApiDataSource()
) : IShowsRepository

{

    override suspend fun getAllCienciaFiccion(): List<shows> {
        return CineRadarShowsSource.getAllCienciaFiccion()
    }

    override suspend fun fetchShows(search : String) : List<shows>{
        return CineRadarShowsSource.getShowsList(search)
    }

    override suspend fun fetchShow(id: String): shows {
        return CineRadarShowsSource.getShowById(id)
    }

}
