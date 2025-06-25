package com.lautarodev.cineradar.shows.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lautarodev.cineradar.shows.Genre
import com.lautarodev.cineradar.shows.ImageSet

//fun fromGenre(list : List<Genre>) : String {
//    return Gson().toJson(list)
//}

fun fromGenre(list: List<Genre>?): String {
    val safeList = list ?: emptyList()
    return Gson().toJson(safeList)
}

fun toGenre(json : String) : List<Genre> {
    return Gson().fromJson(json, object : TypeToken<List<Genre>>() {}.type )
}

//fun fromDirectors(directors: List<String>): String {
//    return Gson().toJson(directors)
//}

fun fromDirectors(directors: List<String>?): String {
    val safeDirectors = directors ?: emptyList()
    return Gson().toJson(safeDirectors)
}

fun toDirectors(json: String): List<String> {
    return Gson().fromJson(json, object : TypeToken<List<String>>() {}.type)
}

//fun fromCast(cast: List<String>): String {
//    return Gson().toJson(cast)
//}

fun fromCast(cast: List<String>?): String {
    val safeCast = cast ?: emptyList()
    return Gson().toJson(safeCast)
}

fun toCast(json: String): List<String> {
    return Gson().fromJson(json, object : TypeToken<List<String>>() {}.type)
}

fun fromImageSet(imageSet: ImageSet): String {
    return Gson().toJson(imageSet)
}

fun toImageSet(json: String): ImageSet {
    return Gson().fromJson(json, ImageSet::class.java)
}