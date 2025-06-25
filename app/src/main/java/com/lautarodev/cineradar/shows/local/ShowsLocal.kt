package com.lautarodev.cineradar.shows.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lautarodev.cineradar.shows.Genre
import com.lautarodev.cineradar.shows.ImageSet


@Entity("shows")
data class ShowsLocal (

    val itemType: String = "",
    val showType: String = "",
    @PrimaryKey val id : String = "",
    val imdbId: String = "",
    val title : String = "",
    val overview : String = "",
    val releaseYear : Int = 0,
    val originalTitle: String = "",
    val genres: String = "",
    val directors: String = "",
    val cast: String = "",
    val rating: Int = 0,
    val runtime: Int = 0,
    val imageSet: String = ""
)
