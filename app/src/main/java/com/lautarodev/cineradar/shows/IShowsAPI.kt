package com.lautarodev.cineradar.shows

import android.icu.text.CaseMap.Title
import android.icu.text.StringSearch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IShowsAPI {

    // endpoints a consumir

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

    @GET("shows/search/filters")
    suspend fun getAllCienciaFiccion(
        @Query("show_type") showType: String = "movie",
        @Query("rating_min") ratingMin: Int = 80,
        @Query("genres") genre: String = "scifi",
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
        ) : CineRadarResult

}