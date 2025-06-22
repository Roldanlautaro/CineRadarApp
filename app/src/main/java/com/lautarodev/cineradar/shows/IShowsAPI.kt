package com.lautarodev.cineradar.shows

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IShowsAPI {

    // Endpoints a consumir

    @GET("shows/search/title")
    suspend fun getShowsSearch(
        @Query("title") title : String,
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
    ) : List<shows>

    @GET("shows/{id}")
    suspend fun getShow(
        @Path("id") id: String,
        @Query("country") country: String = "ar"
    ): shows


    // Pantalla Main

    @GET("shows/search/filters")
    suspend fun getAllCienciaFiccion(
        @Query("show_type") showType: String = "movie",
        @Query("rating_min") ratingMin: Int = 80,
        @Query("genres") genre: String = "scifi",
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
        ) : CineRadarResult

    @GET("shows/search/filters")
    suspend fun getAllMejoresPeliculasNETFLIX(
        @Query("show_type") showType: String = "movie",
        @Query("catalogs") catalogs: String = "netflix",
        @Query("rating_min") ratingMin: Int = 75,
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
    ) : CineRadarResult

    @GET("shows/search/filters")
    suspend fun getAllMejoresPeliculasCienciaFiccionDISNEY(
        @Query("show_type") showType: String = "movie",
        @Query("catalogs") catalogs: String = "disney",
        @Query("rating_min") ratingMin: Int = 75,
        @Query("genres") genre: String = "scifi",
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
    ) : CineRadarResult

    @GET("shows/search/filters")
    suspend fun getAllMejoresPeliculasTerrorHBO(
        @Query("show_type") showType: String = "movie",
        @Query("catalogs") catalogs: String = "hbo",
        @Query("rating_min") ratingMin: Int = 60,
        @Query("genres") genre: String = "horror",
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
    ) : CineRadarResult


    // Pantalla Popular

    @GET("shows/search/filters")
    suspend fun getMejoresSeries(
        @Query("show_type") showType: String = "series",
        @Query("rating_min") ratingMin: Int = 85,
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
    ) : CineRadarResult

    @GET("shows/search/filters")
    suspend fun getMejoresPeliculasDelAnio(
        @Query("show_type") showType: String = "movie",
        @Query("rating_min") ratingMin: Int = 75,
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es",
        @Query("year_min") releaseYear: Int = 2024
    ) : CineRadarResult

    @GET("shows/search/filters")
    suspend fun getMejoresSeriesDeLosUltimosAnios(
        @Query("show_type") showType: String = "series",
        @Query("rating_min") ratingMin: Int = 75,
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es",
        @Query("year_min") releaseYear: Int = 2024
    ) : CineRadarResult

    @GET("shows/search/filters")
    suspend fun getMejoresPeliculas(
        @Query("show_type") showType: String = "movie",
        @Query("rating_min") ratingMin: Int = 85,
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
    ) : CineRadarResult
}