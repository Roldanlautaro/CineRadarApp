package com.lautarodev.cineradar.shows

import android.icu.text.CaseMap.Title
import android.icu.text.StringSearch
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IShowsAPI {
    // endpoints a consumir

    @GET("search/title")
    suspend fun getShowsSearch(
        @Query("title") title : String,
        @Query("country") country: String = "ar",
        @Query("output_language") language: String = "es"
    ) : List<shows>

    @GET("shows/{id}")
    suspend fun getShow(
        @Path("id") id: String,
        @Query("country") country: String = "ar"
    ): CineRadarDetailResult
}